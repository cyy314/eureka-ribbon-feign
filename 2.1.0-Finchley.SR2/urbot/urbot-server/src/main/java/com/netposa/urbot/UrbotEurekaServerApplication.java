package com.netposa.urbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class UrbotEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrbotEurekaServerApplication.class, args);
		//new SpringApplicationBuilder(UrbotEurekaServerApplication.class).run(args);
	}
}
