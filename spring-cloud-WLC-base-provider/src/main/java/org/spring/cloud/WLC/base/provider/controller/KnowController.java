package org.spring.cloud.WLC.base.provider.controller;

import java.util.List;

import org.spring.cloud.WLC.base.provider.domain.KnowSource;
import org.spring.cloud.WLC.base.provider.service.KnowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.searchbox.client.JestResult;

@RestController
@RequestMapping("/know")
public class KnowController {

	@Autowired
	private KnowService service;
	
	@GetMapping("/knowEdit")
	public String knowEdit() {
		return "knowEdit";
	}
	
	@PostMapping("/saveKnow")
	public boolean saveKnow(@RequestBody KnowSource know) {
		return service.saveKnowSource(know).isSucceeded();
	}
	
	/**
	 * 全文搜索
	 * @param content
	 * @return
	 */
	@GetMapping("/searchKnow")
	public List<KnowSource> searchKnow(@RequestParam String content) {
		return service.searchKnowSource(content);
	}
	
	/**
	 * 根据笔记本查询
	 * @param type
	 * @return
	 */
	@GetMapping("/listKnows")
	public List<KnowSource> listKnows(@RequestParam String type) {
		return service.listKnowSources(type);
	}
	
	@PostMapping("/delKnow")
	public boolean delKnowSource(@RequestBody KnowSource know) {
		return service.delKnowSource(know).isSucceeded();
	}
	
	@PostMapping("/updateKnow")
	public boolean updateKnowSource(@RequestBody KnowSource know) {
		return service.updateKnowSource(know).isSucceeded();
	}
}
