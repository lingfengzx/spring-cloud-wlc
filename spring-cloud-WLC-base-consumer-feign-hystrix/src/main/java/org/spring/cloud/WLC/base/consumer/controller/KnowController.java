package org.spring.cloud.WLC.base.consumer.controller;

import org.spring.cloud.WLC.base.consumer.domian.KnowSource;
import org.spring.cloud.WLC.base.consumer.feign.KnowFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/know")
public class KnowController {
	@Autowired
	private KnowFeignClient knowFeignClient;

	@GetMapping("/knowEdit")
	public String knowEdit() {
		System.out.println("knowEdit");
		return knowFeignClient.knowEdit();
	}
	
	@PostMapping("/saveKnow")
	public String saveKnow(@RequestBody KnowSource know) {
		System.out.println("saveKnow");
		System.out.println(know.toString());
		return knowFeignClient.saveKnow(know);
	}
}
