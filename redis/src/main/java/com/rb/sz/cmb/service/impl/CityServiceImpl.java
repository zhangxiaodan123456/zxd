package com.rb.sz.cmb.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rb.sz.cmb.dao.CityDao;
import com.rb.sz.cmb.service.CityService;
/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class CityServiceImpl implements CityService {
	@Autowired
	CityDao cityDao;
	
    public List list() {
    	return cityDao.list();
    }
}
