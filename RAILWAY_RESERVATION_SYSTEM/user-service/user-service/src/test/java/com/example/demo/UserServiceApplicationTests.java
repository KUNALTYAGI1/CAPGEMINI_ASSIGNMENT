package com.example.demo;

import static org.mockito.Mockito.when;


import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ak.entity.User;
import com.ak.repo.UserRepo;
import com.ak.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest

public class UserServiceApplicationTests {

	
	
	

	@MockBean
	private UserRepo userRepo;
	@Autowired
	private  UserService userService;
	
	
	@Test
	public void contextLoads() {
	}
	
	
	
	
	
	
	@Test
	public void saveTest() {
		when(userRepo.save(new User())).thenReturn(new User());
	}
	

	
	
	
	@Test
	public void getByIdTest() {
		when(userRepo.findById(1l)).thenReturn(Optional.of(new User()));
	}
	
	
	
	
	@Test
	public void getRoleByUserIdTest() {
		when(userRepo.findById(1l)).thenReturn(Optional.of(new User()));
		
	}
	
	
	
	
	
	
	@Test
	public void getByEmailTest() {
		when(userRepo.findByEmail("aa@aa.com")).thenReturn(new User());
	}
	
	
	
	
	@Test
	public void getByEmailANdPasswordTest() {
		when(userRepo.findByEmailAndPassword("aa@aa.com","1234")).thenReturn(new User());
	}
	
	
	
	
	
	@Test
	public void getAllTest() {
		when(userRepo.findAll()).thenReturn(Stream.of(new User()).collect(Collectors.toList()));
	}
}
