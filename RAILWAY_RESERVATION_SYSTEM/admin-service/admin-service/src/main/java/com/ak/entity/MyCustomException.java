package com.ak.entity;

import lombok.Data;

@Data
public class MyCustomException extends Exception {
	
	
	private String msg;
	
	public MyCustomException(String msg) {
		this.msg=msg;
				
	}

}
