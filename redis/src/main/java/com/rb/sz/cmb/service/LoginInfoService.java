package com.rb.sz.cmb.service;

import java.util.List;

import com.rb.sz.cmb.domain.LoginInfo;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface LoginInfoService {
	List<LoginInfo> list();
	
	public int insert(LoginInfo log);
}
