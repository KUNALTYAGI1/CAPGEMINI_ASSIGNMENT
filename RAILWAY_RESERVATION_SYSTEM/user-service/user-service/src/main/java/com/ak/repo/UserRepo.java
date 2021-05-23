package com.ak.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ak.entity.User;

@Repository
public interface UserRepo extends MongoRepository<User,Long> {
	
	
	
	
	public User findByEmailAndPassword(String email,String password);
	

	
	public User findByEmail(String email);
}
