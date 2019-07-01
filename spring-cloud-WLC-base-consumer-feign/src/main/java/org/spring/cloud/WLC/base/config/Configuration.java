package org.spring.cloud.WLC.base.config;

import org.springframework.context.annotation.Bean;

import feign.Contract;

@org.springframework.context.annotation.Configuration
public class Configuration {
  @Bean
  public Contract feignContract() {
    return new Contract.Default();
  }
}