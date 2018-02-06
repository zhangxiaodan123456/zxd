package com.rb.sz.cmb.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rb.sz.cmb.domain.City;
import com.rb.sz.cmb.service.CityService;

/**
 * Created by bysocket on 07/02/2017.
 */
@Controller
@RequestMapping("/city")
public class CityRestController {
    @Autowired
    private CityService cityService;
    
    @RequestMapping("/list")
    public String list() {
    	 List<City> list= cityService.list();
         System.out.println(list.toString());
         return "city";
    }

}
