package org.spring.cloud.WLC.base.consumer.feign;

import org.spring.cloud.WLC.base.config.Configuration;
import org.spring.cloud.WLC.base.consumer.domian.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import feign.Param;
import feign.RequestLine;

@FeignClient(value = "provider-base", configuration = Configuration.class)
public interface UserFeignClient {

	/*spring-mvc版本  
	 * @GetMapping (value = "/user/getUser/{id}") public User
	 * getUser(@PathVariable("id")Long id);
	 */
	/**
	 * feign版本 （默认获取的版本）
	 * @param id
	 * @return
	 */
	@RequestLine("GET /user/getUser/{id}")
	public User getUser(@Param("id") Long id);
}