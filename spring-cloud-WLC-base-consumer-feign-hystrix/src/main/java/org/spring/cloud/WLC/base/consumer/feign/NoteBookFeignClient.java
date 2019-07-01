package org.spring.cloud.WLC.base.consumer.feign;

import org.spring.cloud.WLC.base.config.Configuration;
import org.spring.cloud.WLC.base.consumer.domian.KnowSource;
import org.spring.cloud.WLC.base.consumer.hystrix.HystrixClientFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.cloud.wlc.base.domain.notebook.NoteBook;

import feign.Param;
import feign.RequestLine;

@FeignClient(value = "provider-notebook", configuration = Configuration.class, fallbackFactory = HystrixClientFactory.class)
public interface NoteBookFeignClient {
	/**
	 * feign版本 （默认获取的版本）
	 * @param id
	 * @return
	 */
	@RequestLine("POST /notebook/addNoteBook")
	public String addNoteBook(NoteBook know);
	
}
