package org.spring.cloud.WLC.base.consumer.hystrix;

import org.spring.cloud.WLC.base.consumer.domian.KnowSource;
import org.spring.cloud.WLC.base.consumer.feign.KnowFeignClient;
import org.springframework.stereotype.Component;

import feign.RequestLine;

@Component
public class HystrixClientFallback implements KnowFeignClient {

	@Override
	public String saveKnow(KnowSource know) {
		// TODO Auto-generated method stub
		return "editKnow";
	}

	@Override
	public String knowEdit() {
		// TODO Auto-generated method stub
		return "editKnow";
	}
}