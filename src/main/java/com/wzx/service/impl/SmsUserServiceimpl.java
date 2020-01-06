package com.wzx.service.impl;

import com.wzx.dao.SmsUserMapper;
import com.wzx.domain.SmsUser;
import com.wzx.service.SmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wzx
 * @title: SmsUserServiceimpl
 * @projectName SmsWzx
 * @description: ww
 * @date 2020/1/613:36
 */
@Service
public class SmsUserServiceimpl implements SmsUserService {
    @Autowired
    private SmsUserMapper smsUserMapper;

    @Override
    public int deleteByPrimaryKey(Integer smsId) {
        return 0;
    }

    @Override
    public int insert(SmsUser record) {
        return 0;
    }

    @Override
    public int insertSelective(SmsUser record) {
        return 0;
    }

    @Override
    public SmsUser selectByPrimaryKey(Integer smsId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(SmsUser record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(SmsUser record) {
        return 0;
    }

    @Override
    public SmsUser selectLogin(SmsUser smsUser) {
        return smsUserMapper.selectLogin(smsUser);
    }
}
