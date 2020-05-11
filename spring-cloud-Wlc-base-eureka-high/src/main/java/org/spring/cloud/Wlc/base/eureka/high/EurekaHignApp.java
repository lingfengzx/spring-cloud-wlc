package org.spring.cloud.Wlc.base.eureka.high;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class EurekaHignApp
  extends SpringBootServletInitializer
  implements CommandLineRunner
{
  private Logger logger = LoggerFactory.getLogger(EurekaHignApp.class);
  
  public static void main(String[] args)
  {
    SpringApplication.run(EurekaHignApp.class, args);
  }
  
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
  {
    return builder.sources(new Class[] { EurekaHignApp.class });
  }
  
  public void run(String... args)
    throws Exception
  {
    this.logger.info("启动完成!");
  }
}
