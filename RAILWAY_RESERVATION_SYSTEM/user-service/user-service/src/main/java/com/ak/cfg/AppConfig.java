package com.ak.cfg;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableMongoRepositories(basePackages= {"com.ak.repo"})
@EntityScan(basePackages= {"com.ak.entity"})
@ComponentScan(basePackages= {"com.ak.service","com.ak.controller",})
@EnableSwagger2
public class AppConfig {

	
	
	
	
	
	
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("user service").apiInfo(apiInfo()).select()
				.paths(regex("/user.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("User Service")
				.description("user service generated documentation").version("1.0").build();
				//.termsOfServiceUrl("book")
				//.license("Java_Gyan_Mantra License")
				//.licenseUrl("https://www.youtube.com/channel/UCORuRdpN2QTCKnsuEaeK-kQ").version("1.0").build();
	}
	
	
	
	
	
	
	@LoadBalanced
	@Bean
	public RestTemplate getrestTemplate() {
		return new RestTemplate();
	}
}
