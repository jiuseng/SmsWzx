package com.wzx.service;

import com.wzx.domain.SmsUser;

/**
 * @author wzx
 * @title: SmsUserService
 * @projectName SmsWzx
 * @description: ww
 * @date 2020/1/69:28
 */
public interface SmsUserService {
    int deleteByPrimaryKey(Integer smsId);

    int insert(SmsUser record);

    int insertSelective(SmsUser record);

    SmsUser selectByPrimaryKey(Integer smsId);

    int updateByPrimaryKeySelective(SmsUser record);

    int updateByPrimaryKey(SmsUser record);

    /*登录*/
    SmsUser selectLogin(SmsUser smsUser);
}
