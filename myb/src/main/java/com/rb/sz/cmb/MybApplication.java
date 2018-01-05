package com.rb.sz.cmb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.rb.sz.cmb.dao")
@EnableTransactionManagement
public class MybApplication {
	public static void main(String[] args) {
		 SpringApplication.run(MybApplication.class, args);
	}
}
