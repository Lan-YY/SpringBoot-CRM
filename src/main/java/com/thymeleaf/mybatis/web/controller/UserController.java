package com.thymeleaf.mybatis.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.thymeleaf.mybatis.pojo.Role;
import com.thymeleaf.mybatis.pojo.User;
import com.thymeleaf.mybatis.service.RoleService;
import com.thymeleaf.mybatis.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Package: com.thymeleaf.mybatis.web.controller
 * <p>
 * Author: 懒洋洋
 * <p>
 * Date: Created in 2020/1/6 10:13
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    //登录
    @RequestMapping(value = "/dologin")
    public String login(String userName, String password, HttpServletRequest request){
        User user =userService.login(userName,password);
        if (user !=null) {
            request.getSession().setAttribute("user",user);
            return "redirect:/main";
        }else{
            request.setAttribute("message","登录失败，用户名或密码错误");
            return "login";
        }
    }
    //注销
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "login";
    }

//    @GetMapping(value = "/user/list")
//    public String findUsers(Model model){
//        List<User> list = userService.findAllUsers();
//        model.addAttribute("users",list);
//        return "/user/list";
//    }

    @GetMapping(value = "/user/list")
    public String list(Model model,String userName,
                       @RequestParam(required = false,defaultValue = "0")Long roleId,
                       @RequestParam(required = false,defaultValue = "1")int pageIndex){
//        Page<User> page =new Page<User>(1,2);
        IPage<User> pages = userService.findUsersMany(userName, roleId, pageIndex);
        model.addAttribute("pages",pages);
        model.addAttribute("userName",userName);
        model.addAttribute("roleId",roleId);
        List<Role> roles = roleService.findAllRoles();
        model.addAttribute("roles",roles);
        return "/user/list";
    }

    @RequestMapping(value = "/user/add")
    public String add(Model model){
        List<Role> roles = roleService.findAllRoles();
        model.addAttribute("roles",roles);
        return "user/add";
    }

    @RequestMapping(value = "/user/save")
    public String save(User user){
        userService.saveUser(user);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/user/edit/{id}")
    public String edit(@PathVariable("id") Long userId,Model model){
        User user = userService.getUser(userId);
        List<Role> roles = roleService.findAllRoles();
        model.addAttribute("user",user);
        model.addAttribute("roles",roles);
        return "user/edit";
    }

    @RequestMapping(value = "/user/del")
    @ResponseBody
    public Map del(Long userId){
       userService.deleteUser(userId);
       Map map =new HashMap();
       map.put("delResult","true");
       return map;
    }


}
