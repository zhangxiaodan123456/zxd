package com.rb.sz.cmb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {
  @Autowired
  RestTemplate restTemplate;
  @HystrixCommand(fallbackMethod="error")
  public String hi(String name){
	return  restTemplate.getForObject("http://eurekaClient/hi?name="+name, String.class);
  }
  
  public String error(String name){
		return  "error:"+name;
	  }
}
