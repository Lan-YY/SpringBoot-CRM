package com.thymeleaf.mybatis.web.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Package: com.thymeleaf.mybatis.web
 * <p>
 * Author: 懒洋洋
 * <p>
 * Date: Created in 2020/1/8 15:20
 */
public class AuthorizationInterceptor implements HandlerInterceptor {
    @Override
    public   boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("loginUser")==null) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out =response.getWriter();
            out.print("<script>alert('请先进行登录，再进行后续操作!(Interceptor 控制)');" +
                    "location.href='"+request.getContextPath()+"/login';</script>");
            return false;
        }else {
            return true;
        }
    }
}
