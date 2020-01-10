package com.thymeleaf.mybatis.web.controller;

import com.thymeleaf.mybatis.pojo.Role;
import com.thymeleaf.mybatis.service.RoleService;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Package: com.thymeleaf.mybatis.web.controller
 * <p>
 * Author: 懒洋洋
 * <p>
 * Date: Created in 2020/1/8 16:03
 */
@Controller
public class RoleController {

    @Resource
    private RoleService roleService;

    @RequestMapping(value = "/role/json")
    @ResponseBody
    public List<Role> findAllRoles(){
        List<Role> list = roleService.findAllRoles();
        System.out.println(list);
        return list;
    }
}

