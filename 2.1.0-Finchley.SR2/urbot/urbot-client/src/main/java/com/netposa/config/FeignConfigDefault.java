package com.netposa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import feign.Contract;
import feign.Feign;
import feign.RequestLine;

/*
 * 与@RequestLine注解一起使用
 */
@Configuration
public class FeignConfigDefault {

	@Bean
	public Contract fegContract() {
		return new feign.Contract.Default();
	}

}
