package com.netposa.urbotclient.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RibbonConfig {

    @Bean
    @LoadBalanced//默认负载方式轮询
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
