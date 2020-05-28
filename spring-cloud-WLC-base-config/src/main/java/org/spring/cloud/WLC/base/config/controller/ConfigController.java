package org.spring.cloud.WLC.base.config.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {
	@RequestMapping("/change")
	public void configChange() {
		System.out.println("config   change");
	}
}
