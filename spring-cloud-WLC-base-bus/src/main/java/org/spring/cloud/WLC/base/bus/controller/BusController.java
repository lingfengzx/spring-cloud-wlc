package org.spring.cloud.WLC.base.bus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bus")
public class BusController {
	
	@RequestMapping("/config-change")
	public void notifyConfigChange() {
		
	}
}
