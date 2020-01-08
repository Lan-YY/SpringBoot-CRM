package com.thymeleaf.mybatis.service.impl;

import com.thymeleaf.mybatis.mapper.RoleMapper;
import com.thymeleaf.mybatis.pojo.Role;
import com.thymeleaf.mybatis.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Package: com.thymeleaf.mybatis.service.impl
 * <p>
 * Author: 懒洋洋
 * <p>
 * Date: Created in 2020/1/7 10:27
 */
@Service
public class RoleServiceImpl  implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAllRoles() {
        return roleMapper.selectList(null);
    }
}
