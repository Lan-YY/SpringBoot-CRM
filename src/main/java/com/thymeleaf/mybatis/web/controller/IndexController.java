package com.thymeleaf.mybatis.web.controller;

import com.thymeleaf.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Package: com.thymeleaf.mybatis.web.controller
 * <p>
 * Author: 懒洋洋
 * <p>
 * Date: Created in 2020/1/4 20:07
 */
@Controller
public class IndexController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/main")
    public String main(){
        return "main";
    }

}
