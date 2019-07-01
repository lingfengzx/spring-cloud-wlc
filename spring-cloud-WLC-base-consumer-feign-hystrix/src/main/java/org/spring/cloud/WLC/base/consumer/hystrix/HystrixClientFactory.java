package org.spring.cloud.WLC.base.consumer.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.cloud.WLC.base.consumer.domian.KnowSource;
import org.spring.cloud.WLC.base.consumer.feign.KnowFeignClient;
import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

@Component
public class HystrixClientFactory implements FallbackFactory<KnowFeignClient> {

    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFactory.class);

    @Override
    public KnowFeignClient create(Throwable cause) {
        HystrixClientFactory.LOGGER.info("the provider error is: {}", cause.getMessage());
        return new KnowFeignClient() {

			@Override
			public String saveKnow(KnowSource knowSource) {
				// TODO Auto-generated method stub
				return "editKnow";
			}

			@Override
			public String knowEdit() {
				// TODO Auto-generated method stub
				return "knowEdit";
			}
        };
    }
    
}