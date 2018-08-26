package com.netposa.urbotclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "rms")
public class LoginController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(value = "getUserWithDevice",consumes = "application/json")
    public String getUserWithDevice(){
        try{
           String rs =  restTemplate.getForObject("http://urbot-user/user/info",String.class);
            System.out.println(rs);
            return rs;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
