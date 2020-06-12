package org.spring.cloud.WLC.base.oauth2.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Oauth2JWTApp 
{
	    
	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(Oauth2JWTApp.class, args);
    }
}
