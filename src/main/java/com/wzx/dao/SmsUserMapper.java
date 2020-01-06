package com.wzx.dao;

import com.wzx.domain.SmsUser;

public interface SmsUserMapper {
    int deleteByPrimaryKey(Integer smsId);

    int insert(SmsUser record);

    int insertSelective(SmsUser record);

    SmsUser selectByPrimaryKey(Integer smsId);

    int updateByPrimaryKeySelective(SmsUser record);

    int updateByPrimaryKey(SmsUser record);
    /*登录*/
    SmsUser selectLogin(SmsUser smsUser);
}