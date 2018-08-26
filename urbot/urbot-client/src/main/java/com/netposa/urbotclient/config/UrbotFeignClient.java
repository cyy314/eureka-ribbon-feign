package com.netposa.urbotclient.config;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netposa.config.FeignConfigDefault;

import feign.RequestLine;

//@FeignClient(value = "urbot-user")
@FeignClient(name="urbot-user",configuration=FeignConfigDefault.class)
public interface UrbotFeignClient {
    /**
     * 低版本不兼容GetMapping和PostMapping格式注解,并且PathVariable必须指定变量名
     * get请求不能传递对象,传递对象会转为post请求
     * @return
     */
	//@GetMapping(value="user/info")
    //@RequestMapping(value = "user/info",method = RequestMethod.GET)
	@RequestLine("GET /user/info")
    public String getUser();
}
