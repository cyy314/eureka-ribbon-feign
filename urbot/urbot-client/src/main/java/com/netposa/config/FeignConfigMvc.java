package com.netposa.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FeignConfigMvc {

	@Value("${spring.security.user.name}")
	private String username = "test";

	@Value("${spring.security.user.password}")
	private String userpwd = "123456";

	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		return new BasicAuthRequestInterceptor(username, userpwd);
	}

	// feign中禁用hystrix
	@Bean
	@Scope("prototype")
	public Feign.Builder feignBuilder() {
		return Feign.builder();
	}
}
