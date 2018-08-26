package com.netposa.urbotclient;

import com.netposa.urbotclient.config.UrbotRibbonClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "urbot-user",configuration = UrbotRibbonClient.class)
@EnableFeignClients
public class UrbotClientApplication {

	/*@EnableWebSecurity
	static class WebSecurityConfig extends WebSecurityConfigurerAdapter{
		@Override
		protected void configure(HttpSecurity httpSecurity) throws Exception{
			super.configure(httpSecurity);
			httpSecurity.csrf().disable();
		}
	}*/

	public static void main(String[] args) {
		SpringApplication.run(UrbotClientApplication.class, args);
	}
}
