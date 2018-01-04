package com.rb.sz.cmb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@EnableEurekaClient
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		 SpringApplication.run(Application.class, args);
	}
	
	@Value("${server.port}")
	private String port;
	@RequestMapping(value="/hi")
	public String hi(@RequestParam String name){
		return "i am "+name+" from port="+port;
	}
	
	
}
