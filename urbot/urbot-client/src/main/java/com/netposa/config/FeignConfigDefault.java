package com.netposa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;

@Configuration
public class FeignConfigDefault {
	
	@Bean
	public Contract fegContract(){
		return new feign.Contract.Default();
	}

}
