package com.rb.sz.cmb.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="eurekaClient",fallback=HelloServiceImpl.class)
public interface HelloService {
  @RequestMapping(value="/hi")
  public String sayHello(@RequestParam("name") String name);
}
