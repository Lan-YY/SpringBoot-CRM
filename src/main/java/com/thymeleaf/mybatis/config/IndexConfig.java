package com.thymeleaf.mybatis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Package: com.thymeleaf.mybatis.config
 * <p>
 * Author: 懒洋洋
 * <p>
 * Date: Created in 2020/1/4 20:16
 */
@Configuration
public class IndexConfig implements WebMvcConfigurer {

    @Override
    //实现无业务逻辑跳转
    public void addViewControllers(ViewControllerRegistry registry) {
        /*可以通过8080跳转到login页面*/
         registry.addViewController("/").setViewName("forward:/login" );
    }

}
