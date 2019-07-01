package org.spring.cloud.WLC.base.config;

import org.spring.cloud.WLC.base.annotate.ExcludeFromComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;

/**
 * 使用注解方式实现负载均衡策略
 * @author zxk
 *
 */
@Configuration
@ExcludeFromComponentScan
public class AvoidLoanbalanced {
  @Bean
  public IRule ribbonRule() {
    return new RoundRobinRule();        //轮训
    // return new WeightedResponseTimeRule();  //加权权重
    //return new RetryRule();          //带有重试机制的轮训
    //return new RandomRule();          //随机
    //return new TestRule();           //自定义规则
  }
}
