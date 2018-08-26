package com.netposa.urbotuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UrbotUserApplication {

	/*@EnableWebSecurity
	static class WebSecurityConfig extends WebSecurityConfigurerAdapter{
		@Override
		protected void configure(HttpSecurity httpSecurity) throws Exception{
			super.configure(httpSecurity);
			httpSecurity.csrf().disable();
		}
	}*/

	public static void main(String[] args) {
		SpringApplication.run(UrbotUserApplication.class, args);
	}
}
