package com.restful.restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@SpringBootApplication  -> entry point of springboot application.
//							 I can customize bean in this class
@SpringBootApplication
public class RestfulApplication {
    //tomcat is embedded inside, listening on 8080 port
	public static void main(String[] args) {
		SpringApplication.run(RestfulApplication.class, args);
	}

}
