package com.netposa.urbotclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping(value = "/rms")
public class LoginController {

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping(value = "/userdevice", consumes = "application/json")
	public String getUserWithDevice() {
		try {
			String rs = restTemplate.getForObject("http://urbot-user/user/info", String.class);
			System.out.println(rs);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//默认value是THREAD单独使用隔离线程
	@HystrixCommand(fallbackMethod="getDefaultUser",commandProperties={
			@HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
	})
	//@HystrixCommand(fallbackMethod="getDefaultUser")
	@GetMapping("/user")
	public String getUser() {
		try {
			String rs = restTemplate.getForObject("http://urbot-user/user/info", String.class);
			return rs;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String getDefaultUser(){
		return "{\"msg\":\"ribbon hystrix\"}";
	}
}
