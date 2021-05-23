package com.ak.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ak.entity.User;


public interface UserService {
	
	/**
	 * save new user
	 */
	public User save(User user)throws Exception;
	
	
	/**
	 * get user by id
	 */
	public User getById(long userId)throws Exception;
	
	
	/**
	 * get role by userId
	 */
	public String getRoleByUserId(long userId)throws Exception;
	
	/**
	 * find by email
	 */
	public User getByEmail(String email)throws Exception;
	
	/**
	 * get by email and password
	 */
	public User getByEmailANdPassword(String email,String password)throws Exception;
	
	/**
	 * find all users
	 */
   public List<User> getAll()throws Exception;
}
