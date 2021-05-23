package com.ak.customexe;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionController  {
	
	
	
	@ExceptionHandler(value= {NoSuchElementException.class})
	public ResponseEntity<String> sendNoElementException(Exception e){
	e.printStackTrace();
		return ResponseEntity.ok().body("no value available");
	}
	

}
