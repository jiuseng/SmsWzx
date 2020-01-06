package com.wzx.dao;

import com.wzx.domain.SmsPermission;

public interface SmsPermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SmsPermission record);

    int insertSelective(SmsPermission record);

    SmsPermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmsPermission record);

    int updateByPrimaryKey(SmsPermission record);
}