package com.netposa.urbotclient.controller;

import com.netposa.urbotclient.config.ServerFeignClient;
import com.netposa.urbotclient.config.UrbotFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {
	
	@Autowired
    private LoadBalancerClient loadBalancerClient;

	@Autowired
    private UrbotFeignClient urbotFeignClient;

	@Autowired
    private ServerFeignClient serverFeignClient;
	

    @GetMapping(value = "/1")
    public String test1(){
        ServiceInstance si = loadBalancerClient.choose("urbot-user");
        String rs = si.getHost() + ":" + si.getPort() + ":" + si.getServiceId();
        System.out.println(rs);
        return rs;
    }

    @GetMapping(value = "/2")
    public String getUser(){
        return urbotFeignClient.getUser();
    }
    
    @GetMapping(value = "/{serverName}")
    public String getServer(@PathVariable("serverName")String serverName){
        return serverFeignClient.getServerInfo(serverName);
    }
}
