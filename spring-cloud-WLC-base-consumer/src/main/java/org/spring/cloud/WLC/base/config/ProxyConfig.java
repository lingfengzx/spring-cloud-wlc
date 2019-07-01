package org.spring.cloud.WLC.base.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 网络代理设置
 * 
 * @author yangzhilong
 *
 */
@Component
@ConfigurationProperties(prefix="proxy")
@Data
public class ProxyConfig {
    /**
     * 是否启用代理
     */
    private Boolean enabled;
    /**
     * 代理主机地址
     */
    private String host;
    /**
     * 代理端口    
     */
    private Integer port;
    
}