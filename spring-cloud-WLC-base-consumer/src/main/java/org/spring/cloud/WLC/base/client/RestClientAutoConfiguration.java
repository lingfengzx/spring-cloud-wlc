package org.spring.cloud.WLC.base.client;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;

import org.spring.cloud.WLC.base.config.ProxyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 工具类引导装配类
 * @author yangzhilong
 *
 */
@Configuration
@ConditionalOnClass(ProxyConfig.class)
public class RestClientAutoConfiguration {
    @Value("${rest.config.connectTimeout:10000}")
    private int connectTimeout;
    @Value("${rest.config.readTimeout:30000}")
    private int readTimeout;
    @Autowired
    private ProxyConfig proxyConfig;
    
    /**
     * 使用Bootstrap来装配RestClient中的RestTemplate属性，
     * 避免直接装配RestTemplate来污染了正常的spring Cloud的调用
     * @return
     */
    @Bean
    public RestClientBootstrap bootstrap(){
    	SimpleClientHttpRequestFactory httpRequestFactory = new SimpleClientHttpRequestFactory();
        System.out.println(httpRequestFactory);
    	httpRequestFactory.setConnectTimeout(connectTimeout);
        httpRequestFactory.setReadTimeout(readTimeout);
        System.out.println(proxyConfig);
        if(proxyConfig.getEnabled()){
            SocketAddress address = new InetSocketAddress(proxyConfig.getHost(), proxyConfig.getPort());
            //Proxy proxy = new Proxy(Proxy.Type.HTTP, address);
            Proxy proxy = new Proxy(Proxy.Type.SOCKS, address);
            System.out.println(proxy);
            httpRequestFactory.setProxy(proxy);
        }
       
        RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
        RestClient.setRestTemplate(restTemplate);
        return new RestClientBootstrap();
    }
    
    /**
     * 空的引导类
     * @author yangzhilong
     *
     */
    static class RestClientBootstrap {
        
    }
}