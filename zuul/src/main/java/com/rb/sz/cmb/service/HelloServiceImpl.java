package com.rb.sz.cmb.service;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceImpl implements HelloService{

	@Override
	public String sayHello(String name) {
		return "111error:"+name;
	}

}
