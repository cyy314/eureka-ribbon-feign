package com.netposa.urbotclient;

import com.netposa.urbotclient.config.UrbotRibbonClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "urbot-user",configuration = UrbotRibbonClient.class)//配置ribbon负载策略
@EnableFeignClients
@EnableCircuitBreaker//不建议使用
/**
 * ribbon-hystrix
 * I/O error on GET request for "http://urbot-user/user/info": Connection refused: connect; nested exception is java.net.ConnectException: Connection refused: connect
 * 服务宕机后使用hystrix可能会出现以上类似问题
 * @author Administrator
 *
 */
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
