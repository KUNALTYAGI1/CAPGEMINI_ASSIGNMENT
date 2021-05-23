package com.ak.service;

public interface JwtTokenService {

	
	
	public String generateToken(long userId,String role)throws Exception ;
	
	
	
	
	
	
	public boolean isValid(String token);
	
	
	public Integer extractTokenId(String token);
	
	
	public Long extractUserId(String token)throws Exception;
	public String extractRole(String token)throws Exception;
}
