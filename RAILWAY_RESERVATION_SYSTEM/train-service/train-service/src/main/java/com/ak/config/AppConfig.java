package com.ak.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.ak.customexe.CustomExeConfig;
import com.ak.train.cfg.TrainConfig;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@Import(value= {CustomExeConfig.class,TrainConfig.class})
@EnableSwagger2
public class AppConfig {

	
	
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("train service").apiInfo(apiInfo()).select()
				.paths(regex("/train.*"))
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Train Service")
				.description("train service generated documentation").version("1.0").build();
				//.termsOfServiceUrl("book")
				//.license("Java_Gyan_Mantra License")
				//.licenseUrl("https://www.youtube.com/channel/UCORuRdpN2QTCKnsuEaeK-kQ").version("1.0").build();
	}
	
}
