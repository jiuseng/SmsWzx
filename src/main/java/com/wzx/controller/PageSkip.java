package com.wzx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wzx
 * @title: PageSkip
 * @projectName SmsWzx
 * @description: ww
 * @date 2020/1/313:53
 */
@Controller
@RequestMapping("/page")
public class PageSkip {

    @RequestMapping("login")
    public String loginPage(){
        return "login";
    }

}
