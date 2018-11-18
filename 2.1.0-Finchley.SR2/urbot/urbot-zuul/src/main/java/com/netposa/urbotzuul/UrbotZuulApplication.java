package com.netposa.urbotzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class UrbotZuulApplication {

	/*@EnableWebSecurity
	static class WebSecurityConfig extends WebSecurityConfigurerAdapter{
		@Override
		protected void configure(HttpSecurity httpSecurity) throws Exception{
			super.configure(httpSecurity);
			httpSecurity.csrf().disable();
		}
	}*/
	
	/**
	 * 使用此功能需要微服务名称-v*的格式，访问可以通过v* /serviceid/url
	 * @return
	 */
	@Bean
	public PatternServiceRouteMapper serviceRouteMapper() {
	    return new PatternServiceRouteMapper(
	        "(?<name>^.+)-(?<version>v.+$)",
	        "${version}/${name}");
	}

	public static void main(String[] args) {
		SpringApplication.run(UrbotZuulApplication.class, args);
	}
}
