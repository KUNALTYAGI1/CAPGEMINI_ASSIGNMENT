package com.ak.service;

import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtTokenServiceImpl implements JwtTokenService {
	
	String secretKey="jwtsecretkeyFullySecret";
	
	
	
	
	
	
	
	
	@Override
	public String generateToken(long userId,String role)throws Exception {
		return createToken(createClaims(userId,role));
	}
	
	
	
	
	
	
	
	
	private Claims createClaims(long userId,String role) {
	    Claims claims=Jwts.claims();
		claims.put("userId", userId);
		claims.put("role",role);
		return claims;
	}
	
	
	
	
	
	
	
	
	
	
	//create token
	private String createToken(Claims claims) {
		//ProfileDto4SessionJWT profileDto4SessionJWT=(ProfileDto4SessionJWT) claims.get("profileDto4SessionJWT",ProfileDto4SessionJWT.class);
		
		
	return	Jwts.builder().claim("claims",claims)
		  .setId(String.valueOf(claims.get("userId",Long.class)))
		  .setSubject("secretsubject")
             .setIssuer("jwt service")
               .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*24))
                 .signWith(SignatureAlgorithm.HS256,secretKey)
                   .compact();
	}

	
	
	
	
	
	
	
	
	
	
	//validate token
	
	private Claims extractClaims(String token) {
		//check is expired
		Claims claims= Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
		return claims;
	}
	
	
	
	
	
	
	
	public long extractUserId(Claims claims) {
		String json=null;
		Gson  gson=new Gson();
		Object obj= claims.get("claims",new HashMap<>().getClass()).get("userId");
		json=gson.toJson(obj);
		return gson.fromJson(json,Long.class);
	}
	
	
	
	
	
	
	

	public String extractRole(Claims claims) {
		String json=null;
		Gson  gson=new Gson();
		Object obj=claims.get("claims",new HashMap<>().getClass()).get("role");
		
		json=gson.toJson(obj);
		return gson.fromJson(json,String.class);
	}
	
	
	
	
	
	
	
	
	
	@Override
	public Long extractUserId(String token)throws Exception {
		
		long userId=0;
		String json=null;
		Gson  gson=new Gson();
		
		
		Claims claims=extractClaims(token);
		
		Object obj=claims.get("claims",new HashMap<>().getClass()).get("userId");
		json=gson.toJson(obj);
		userId= gson.fromJson(json,Long.class);
		
		return userId;
	}
	
	
	
	
	
	
	

	@Override
	public String extractRole(String token)throws Exception {
		
		String role=null;
		String json=null;
		Gson  gson=new Gson();
		
		
		Claims claims=extractClaims(token);
		
		Object obj= claims.get("claims",new HashMap<>().getClass()).get("role");
		
		json=gson.toJson(obj);
		role= gson.fromJson(json,String.class);
		
		return role;
	}
	
	
	
	
	
	
	private Integer extractTokenId(Claims claims) {
		return Integer.parseInt(claims.getId());		
	}
	
	
	@Override
	public Integer extractTokenId(String token) {
		Claims claims=extractClaims(token);
		return Integer.parseInt(claims.getId());		
	}
	
	
	
	
	@Override
	public boolean isValid(String token) {
		boolean valid=false;
		try {
		valid=!isExpired(extractClaims(token));
		}catch (Exception e) { e.printStackTrace();
			valid=false;
		}return valid;
	}
	
	
	
	public boolean isExpired(Claims claims) {
		return claims.getExpiration().before(new Date(System.currentTimeMillis()));
	}
}
