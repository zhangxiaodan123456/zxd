package com.rb.sz.cmb.controller;


import java.util.List;

import org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi.ecCVCDSA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rb.sz.cmb.domain.City;
import com.rb.sz.cmb.domain.LoginInfo;
import com.rb.sz.cmb.service.CityService;
import com.rb.sz.cmb.service.LoginInfoService;
import com.rb.sz.cmb.service.impl.RedisService;

/**
 * Created by bysocket on 07/02/2017.
 */
@Controller
@RequestMapping("/city")
public class CityRestController {
    @Autowired
    private CityService cityService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private LoginInfoService loginInfoService;
    
    @RequestMapping("/list")
    public String list() {
    	 redisService.setValue("dan", "yqr");
    	 System.out.println(redisService.getValue("dan"));
    	 List<City> list= cityService.list();
         System.out.println(list.toString());
         return null;
    }
    
    @RequestMapping("/log")
    public String log() {
    	 List<LoginInfo> list= loginInfoService.list();
         System.out.println(list.toString());
         return null;
    }
    
    @RequestMapping("/add")
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public String add() {
    	 try {
    		 LoginInfo log=new LoginInfo();
    	   	 log.setId(4);
    	   	 log.setUsername("hah");
    	   	 log.setPassword("df");
    	   	 log.setState(0);
    		 loginInfoService.insert(log);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	 return null;
    }
}
