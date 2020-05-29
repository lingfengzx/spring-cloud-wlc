package org.spring.cloud.WLC.base.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/config")
public class ConfigController {
	@RequestMapping("/hello")
	public String hello() {
		return "hello config server";
	}
}
