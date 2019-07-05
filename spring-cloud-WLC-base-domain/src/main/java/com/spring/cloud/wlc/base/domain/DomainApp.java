package com.spring.cloud.wlc.base.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Hello world!
 * 因为父项目中有SpringBoot-start，打包时提示必须要启动类，所以加了这个，实际上不需要。
 * exclude：表示不需要连数据库
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class DomainApp
{
    public static void main( String[] args )
    {
    	SpringApplication.run(DomainApp.class, args);
    }
    
}
