package com.rb.sz.cmb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rb.sz.cmb.dao.IplogMapper;
import com.rb.sz.cmb.domain.Iplog;
import com.rb.sz.cmb.service.IpLogService;

@Service
public class IpLogServiceImpl implements IpLogService{
	@Autowired
	IplogMapper iplogMapper;
	@Override
	public int insert(Iplog log) {
		return iplogMapper.insert(log);
	}

}
