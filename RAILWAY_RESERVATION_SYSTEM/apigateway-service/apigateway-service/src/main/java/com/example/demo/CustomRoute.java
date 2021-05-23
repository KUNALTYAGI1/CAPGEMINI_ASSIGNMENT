package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration

public class CustomRoute {

	@Value("${clientOrigin}")
	private String clientOrigin;
	
	@Bean
	public RouteLocator getRL(RouteLocatorBuilder builder) {
		
	return	builder.routes()
		
			.route(p->
			 p.path("/train/**","/seat/**")
			 .filters(f ->{
				 f.setResponseHeader("Access-Control-Allow-Origin",clientOrigin);
				 return f;
			 })
			.uri("lb://TRAIN-SERVICE"))
			
			
			
			
			
			.route(p->
			 p.path("/admin/**")
			 .filters(f ->{
				 f.setResponseHeader("Access-Control-Allow-Origin",clientOrigin);
				 return f;
			 })
			.uri("lb://ADMIN-SERVICE"))
			
			
			
			
			
			.route(p->
			 p.path("/psn/**")
			 .filters(f ->{
				 f.setResponseHeader("Access-Control-Allow-Origin",clientOrigin);
				 return f;
			 })
			.uri("lb://PASSENGER-SERVICE"))
						
		.build();		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
