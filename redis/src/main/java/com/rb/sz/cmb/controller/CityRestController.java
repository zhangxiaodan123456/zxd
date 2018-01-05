package com.rb.sz.cmb.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rb.sz.cmb.domain.City;
import com.rb.sz.cmb.service.CityService;
import com.rb.sz.cmb.service.impl.RedisService;

/**
 * Created by bysocket on 07/02/2017.
 */
@RestController
@RequestMapping("/city")
public class CityRestController {
    @Autowired
    private CityService cityService;
    @Autowired
    private RedisService redisService;
    
    @RequestMapping("/list")
    public String list() {
    	 redisService.setValue("dan", "yqr");
    	 System.out.println(redisService.getValue("dan"));
    	 List<City> list= cityService.list();
         System.out.println(list.toString());
         return "jskjf";
    }

}
