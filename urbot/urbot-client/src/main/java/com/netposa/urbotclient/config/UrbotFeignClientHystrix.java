package com.netposa.urbotclient.config;

import org.springframework.stereotype.Component;

@Component
public class UrbotFeignClientHystrix implements UrbotFeignClient {

	@Override
	public String getUser() {
		return "{\"msg\":\"server is blocking\"}";
	}

}
