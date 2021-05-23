package com.ak.service;

import lombok.Data;

@Data
public class MyCustomException extends Exception {
	
	
	private String msg;
	
	public MyCustomException(String msg) {
		this.msg=msg;
				
	}

}
