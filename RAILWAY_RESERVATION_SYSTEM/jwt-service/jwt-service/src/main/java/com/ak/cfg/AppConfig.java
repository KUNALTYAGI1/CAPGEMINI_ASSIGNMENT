package com.ak.cfg;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ComponentScan(basePackages= {"com.ak.service","com.ak.controller"})
@EnableSwagger2
public class AppConfig {

	
	
	
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("jwt service").apiInfo(apiInfo()).select()
				.paths(regex("/jwt.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Jwt Service")
				.description("jwt service generated documentation").version("1.0").build();
				//.termsOfServiceUrl("book")
				//.license("Java_Gyan_Mantra License")
				//.licenseUrl("https://www.youtube.com/channel/UCORuRdpN2QTCKnsuEaeK-kQ").version("1.0").build();
	}
}
