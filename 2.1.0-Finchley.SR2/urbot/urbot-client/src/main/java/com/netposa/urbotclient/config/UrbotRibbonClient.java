package com.netposa.urbotclient.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

/**
 * 自定义ribbonclient不能放在启动类的扫描目录,否则会针对所有服务使用自定义负载策略
 * 如果放在启动类目录下需要加上自定义注解避免初始化,并且启动类加上
 * @ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = ExcludeComponentScan,clsee)})
 */
@Configuration
public class UrbotRibbonClient {
    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
