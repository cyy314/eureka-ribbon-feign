package com.netposa.urbotdevice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "device")
public class DeviceController {

    @GetMapping(value = "info", produces = "application/json;charset=utf-8")
    public String getInfo(){
        return "{\"name\":\"robot\"}";
    }
}
