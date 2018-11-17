package com.netposa.urbotclient.config;

//import org.springframework.cloud.netflix.feign.encoding.FeignAcceptGzipEncodingAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//import feign.Feign;

@Component
public class UrbotFeignClientHystrix implements UrbotFeignClient {

	@Override
	public String getUser() {
		return "{\"msg\":\"server is blocking\"}";
	}

}
