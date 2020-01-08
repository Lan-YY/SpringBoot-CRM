package com.thymeleaf.mybatis.config;

import com.thymeleaf.mybatis.web.interceptor.AuthorizationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Package: com.thymeleaf.mybatis.config
 * <p>
 * Author: 懒洋洋
 * <p>
 * Date: Created in 2020/1/8 15:32
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    private String[] excludePathPatterns;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] pathPatterns={"/"}; //拦截路径规则
        String[] excludePathPatterns={"/","/login","/dologin.html","/css","/fonts/**","/images/**","/js/**","/localcss/**","localjs/**"};
        registry.addInterceptor(new AuthorizationInterceptor()).addPathPatterns(pathPatterns).excludePathPatterns(excludePathPatterns); //
    }



}
