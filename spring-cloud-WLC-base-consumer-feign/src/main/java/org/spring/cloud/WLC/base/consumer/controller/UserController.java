package org.spring.cloud.WLC.base.consumer.controller;

import org.spring.cloud.WLC.base.consumer.domian.User;
import org.spring.cloud.WLC.base.consumer.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserFeignClient userFeignClient;

	@GetMapping("/getUser/{id}")
	public User getUser(@PathVariable Long id) {
		return userFeignClient.getUser(id);
	}
}
