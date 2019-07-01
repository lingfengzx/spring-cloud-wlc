package org.spring.cloud.WLC.base.consumer.controller;

import org.spring.cloud.WLC.base.client.RestClient;
import org.spring.cloud.WLC.base.client.RestClientAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proxy")
public class ProxyController {
	
    @GetMapping("/getCloud/{id}")
    public String getCloud(@PathVariable Long id){
        return RestClient.get("http://provider-base/user/getUser/"+id);
    }
}
