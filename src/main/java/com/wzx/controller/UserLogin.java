package com.wzx.controller;

import com.wzx.domain.SmsUser;
import com.wzx.service.SmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wzx
 * @title: UserLogin
 * @projectName SmsWzx
 * @description: ww
 * @date 2020/1/613:39
 */
@RequestMapping("/user")
@Controller
public class UserLogin {
    @Autowired
    private SmsUserService smsUserService;

   @RequestMapping("/request")
   @ResponseBody
    public SmsUser Login(SmsUser smsUser){
       System.out.println("登录传过来的对象为"+smsUser);
       SmsUser smsUser1= smsUserService.selectLogin(smsUser);
       System.out.println("登录的结果为"+smsUser1);
        return smsUser1;
    }
}
