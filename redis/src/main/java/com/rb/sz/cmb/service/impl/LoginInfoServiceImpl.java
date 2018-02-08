package com.rb.sz.cmb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rb.sz.cmb.dao.LoginInfoMapper;
import com.rb.sz.cmb.domain.LoginInfo;
import com.rb.sz.cmb.service.LoginInfoService;
/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class LoginInfoServiceImpl implements LoginInfoService{
	@Autowired
	LoginInfoMapper  loginInfoMapper;
	public List list() {
		return loginInfoMapper.selectAll();
	}
	@Override
	public int insert(LoginInfo log) {
	   	return loginInfoMapper.insert(log);
	}
}
