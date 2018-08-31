package com.netposa.urbotuser.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping(value = "info", produces = "application/json;charset=utf-8")
    public String getInfo(){
        return "{\"name\":\"test\"}";
    }
    
    @PostMapping("/login")
    public String login(HttpServletRequest request) {
    	String name = request.getParameter("name");
    	String pwd = request.getParameter("pwd");
    	System.out.println(name+":"+pwd);
    	return String.valueOf(System.currentTimeMillis());
    }
}
