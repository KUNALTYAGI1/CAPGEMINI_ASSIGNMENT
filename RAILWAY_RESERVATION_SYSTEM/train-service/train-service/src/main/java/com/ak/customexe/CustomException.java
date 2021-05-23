package com.ak.customexe;

public class CustomException  extends Exception{
	
	private String msg;
	
	public CustomException(String msg) {
		this.msg=msg;
	}

}
