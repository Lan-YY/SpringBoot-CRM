package com.thymeleaf.mybatis.config;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Package: com.thymeleaf.mybatis.config
 * <p>
 * Author: 懒洋洋
 * <p>
 * Date: Created in 2020/1/7 9:00
 */
@Configuration
public class MybatisPlusConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
