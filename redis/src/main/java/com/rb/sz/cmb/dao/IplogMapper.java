package com.rb.sz.cmb.dao;

import java.util.List;

import com.rb.sz.cmb.domain.Iplog;

public interface IplogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Iplog record);

    Iplog selectByPrimaryKey(Long id);

    List<Iplog> selectAll();

    int updateByPrimaryKey(Iplog record);
}