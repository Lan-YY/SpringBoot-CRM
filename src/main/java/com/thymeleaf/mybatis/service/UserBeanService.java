package com.thymeleaf.mybatis.service;

import com.thymeleaf.mybatis.pojo.UserBean;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

/**
 * Package: com.thymeleaf.mybatis.service
 * <p>
 * Author: 懒洋洋
 * <p>
 * Date: Created in 2020/1/9 10:37
 */

public interface UserBeanService {
    UserBean getUser(String userName);
}
