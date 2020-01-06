package com.wzx.dao;

import com.wzx.domain.SmsRole;

public interface SmsRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SmsRole record);

    int insertSelective(SmsRole record);

    SmsRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmsRole record);

    int updateByPrimaryKey(SmsRole record);
}