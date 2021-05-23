package com.ak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ak.entity.User;
import com.ak.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	
	
	
	@Override
	public User save(User user) throws Exception {
		return userRepo.save(user);
	}

	
	
	
	
	@Override
	public User getById(long userId) throws Exception {
		return userRepo.findById(userId).get();
	}

	
	
	
	@Override
	public String getRoleByUserId(long userId) throws Exception {
		return userRepo.findById(userId).get().getRole().name();
	}
	
	
	
	@Override
	public User getByEmail(String email) throws Exception {
		User user=null;
		user=userRepo.findByEmail(email);
		return user;
	}
	
	
	
	@Override
	public User getByEmailANdPassword(String email, String password) throws Exception {
      return userRepo.findByEmailAndPassword(email,password);
		
	}
	
	
	
	
	@Override
	public List<User> getAll() throws Exception {
		return userRepo.findAll();	
	}
	
	

}
