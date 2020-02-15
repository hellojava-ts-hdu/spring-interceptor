package com.yiyue.lesson.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InterceptorController {

    @GetMapping("/home/open/info")
    public String home(){
        return "欢迎访问首页";
    }

    @GetMapping("/home/info")
    public String login(){
        return "我被拦截了";
    }

    @GetMapping("/open/unLogin")
    public String unLogin(){
        return "尚未登录，请登录";
    }
}
