package com.thymeleaf.mybatis.service;

import com.thymeleaf.mybatis.pojo.UserBean;

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
