package org.spring.cloud.WLC.base.consumer.feign;

import org.spring.cloud.WLC.base.config.Configuration;
import org.spring.cloud.WLC.base.consumer.domian.KnowSource;
import org.spring.cloud.WLC.base.consumer.hystrix.HystrixClientFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import feign.Param;
import feign.RequestLine;

@FeignClient(value = "provider-base", configuration = Configuration.class, fallbackFactory = HystrixClientFactory.class)
public interface KnowFeignClient {
	/**
	 * feign版本 （默认获取的版本）
	 * @param id
	 * @return
	 */
	@RequestLine("POST /know/saveKnow")
	public String saveKnow(KnowSource know);
	
	@RequestLine("GET /know/knowEdit")
	public String knowEdit();
}
