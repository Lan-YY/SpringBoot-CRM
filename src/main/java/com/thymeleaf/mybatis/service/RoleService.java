package com.thymeleaf.mybatis.service;

import com.thymeleaf.mybatis.pojo.Role;

import java.util.List;

/**
 * Package: com.thymeleaf.mybatis.service
 * <p>
 * Author: 懒洋洋
 * <p>
 * Date: Created in 2020/1/7 10:27
 */
public interface RoleService {
    List<Role> findAllRoles();
}
