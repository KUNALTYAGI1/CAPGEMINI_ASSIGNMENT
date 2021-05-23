package com.ak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 100)
@RestController
@RequestMapping("/jwt")
public class JwtController {

	@Autowired
	private com.ak.service.JwtTokenService jwtTokenService;
	
	
	
	//@CrossOrigin(allowedHeaders = {"http://localhost:9097","authorization", "content-type", "x-auth-token"})
	@PostMapping(path="/createToken/{userId}/{role}")
	public String generateToken(@PathVariable("userId") long userId,@PathVariable("role")String role)throws Exception {		
          return jwtTokenService.generateToken(userId, role);
	}
	
	
	
	
	
	
	
	
	//@CrossOrigin(allowedHeaders = {"http://localhost:9097","authorization", "content-type", "x-auth-token"})
	@PostMapping(path="/isValidToken")
	public boolean validToken(@RequestBody String token) {
		return jwtTokenService.isValid(token);
	}
	
	
	
	//@CrossOrigin(allowedHeaders = {"http://localhost:9097","authorization", "content-type", "x-auth-token"})
	@PostMapping(path="/getUserId")
	public long getUserIdFromToken(@RequestBody String token)throws Exception {
		return jwtTokenService.extractUserId(token);
	}
	
	
	
	
	//@CrossOrigin(allowedHeaders = {"http://localhost:9097","authorization", "content-type", "x-auth-token"})
		@PostMapping(path="/getRole")
		public String getRoleFromToken(@RequestBody String token)throws Exception {
			return jwtTokenService.extractRole(token);
		}
		
	
	
	
}
