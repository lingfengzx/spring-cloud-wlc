package org.spring.cloud.WLC.base.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@ComponentScan("org.spring.cloud.WLC.base")
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "provider-base", configuration = org.spring.cloud.WLC.base.config.LoadBalanced.class)
/*
 * 下面这个是注解方式实现负载均衡策略
 */
//@RibbonClient(name = "provider-base", configuration = AvoidLoanbalanced.class)
//@ComponentScan(excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class) })
public class ConsumerApp 
{
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApp.class, args);
	}
}
