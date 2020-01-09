package com.thymeleaf.mybatis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.thymeleaf.mybatis.mapper.UserBeanMapper;
import com.thymeleaf.mybatis.pojo.UserBean;
import com.thymeleaf.mybatis.service.UserBeanService;
import com.thymeleaf.mybatis.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Package: com.thymeleaf.mybatis.service.impl
 * <p>
 * Author: 懒洋洋
 * <p>
 * Date: Created in 2020/1/9 10:38
 */
@Service
public class UserBeanServiceImpl implements UserBeanService {

    @Resource
    private UserBeanMapper userBeanMapper;

    @Override
    public UserBean getUser(String userName) {
        QueryWrapper<UserBean> queryWrapper = new QueryWrapper<UserBean>();
        queryWrapper.eq("userName",userName);

        return userBeanMapper.selectOne(queryWrapper);
    }
}
