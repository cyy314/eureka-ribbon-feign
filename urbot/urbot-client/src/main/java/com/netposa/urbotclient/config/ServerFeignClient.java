package com.netposa.urbotclient.config;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netposa.config.FeignConfigMvc;

import feign.RequestLine;

@FeignClient(name="all",url="http://localhost:8761/",configuration=FeignConfigMvc.class)
public interface ServerFeignClient {
   
    @RequestMapping(value = "/eureka/apps/{serverName}",method = RequestMethod.GET)	
    public String getServerInfo(@PathVariable("serverName")String serverName);
}
