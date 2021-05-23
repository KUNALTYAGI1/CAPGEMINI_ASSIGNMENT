package com.ak.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="user")

public class User {
	@Id
	private long userId;
	private String name;
	private String email;
	private String password;
	private Gender gender;
	private Date dob;
	private Role role=Role.USER;
	

	
	
	
	
	
	
	public enum Role{
		ADMIN,USER
	}
	
	public enum Gender{
		MALE,FEMALE,OTHER
	}
}
