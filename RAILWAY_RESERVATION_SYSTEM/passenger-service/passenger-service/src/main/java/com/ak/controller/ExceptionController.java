package com.ak.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.ak.service.MyCustomException;

@RestController
@ControllerAdvice
public class ExceptionController {
	
	
	
	@ExceptionHandler(value= {MyCustomException.class})
	public ResponseEntity<String> customExceptionHandler(MyCustomException e){
		e.printStackTrace();
		return ResponseEntity.ok().body(e.getMsg());
	}
	
	
	
	

	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<String> exceptionHandler(Exception e){
		e.printStackTrace();
		return ResponseEntity.ok().body("somthing wrong");
	}

}
