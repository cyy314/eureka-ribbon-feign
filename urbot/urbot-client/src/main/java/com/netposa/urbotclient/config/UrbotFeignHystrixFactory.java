package com.netposa.urbotclient.config;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;
/**
 * 当服务上线后不会立即识别有几秒延时
 * @author Administrator
 *
 */
@Component
public class UrbotFeignHystrixFactory implements FallbackFactory<UrbotFeignClient> {

	@Override
	public UrbotFeignClient create(Throwable arg0) {
		return new UrbotFeignClient() {			
			@Override
			public String getUser() {
				return "{\"msg\":\"fallback factory server is blocking\"}";
			}
		};
	}

}
