package com.ak.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ak.entity.User;
import com.ak.service.UserService;


@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private RestTemplate rt;
	
	@PostMapping(path="/login")
	public String login(@RequestParam("email")String email,@RequestParam("password")String password,HttpServletRequest req)throws Exception{
		
		
		User user=null;
		HttpSession ses=null;
		if(email==null || password==null)
			return "email or password is empty";
		
		
		user=userService.getByEmailANdPassword(email, password);

		if(user==null) return "invalid details";
		
		ses=req.getSession();
		ses.setAttribute("userId",user.getUserId());
		ses.setAttribute("userRole",user.getRole());
		ses.setAttribute("token",createToken(user.getUserId(), user.getRole().name()));
		return "you are logged your token is "+ses.getAttribute("token").toString();
	};
	
	
	
	
	
	/**
	 * get user by id
	 */
	@GetMapping("/get/byId/{userId}")
	public User getUserById(@PathVariable("userId")long userId)throws Exception {
		return userService.getById(userId);
	}
	
	
	
	
	
	/**
	 * get role by userId
	 */
	@GetMapping(path="/get/roleById/{userId}")
	public String getRoleByUserId(@PathVariable("userId")long userId)throws Exception{
		return userService.getRoleByUserId(userId);
	};
	
	
	
	/**
	 * create new user this is registration
	 */
	@PostMapping(path="/createNewUser")
	public String createUser(@RequestBody User user,HttpServletRequest req)throws Exception{	
		HttpSession ses=null;
		boolean emailRegistered=false;
		if(user.getEmail()==null || user.getPassword()==null)
			return "emailand password field can't be empty";
		
		//check if email aleady registered
		emailRegistered=!(userService.getByEmail(user.getEmail())==null);
		if(emailRegistered) 
			return "email already registered";
		user=userService.save(user);
		ses=req.getSession();
		ses.setAttribute("userId",user.getUserId());
		ses.setAttribute("userRole",user.getRole());
		ses.setAttribute("token",createToken(user.getUserId(), user.getRole().name()));
		return "user created with id"+user.getUserId();	
	};
	
	
	
	
	
	
	
	private String createToken(long userId,String role)throws Exception {
	  return rt.postForObject("http://JWT-SERVICE/jwt/createToken/"+userId+"/"+role,null, String.class);	
	}
	
	
}
