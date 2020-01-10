package com.thymeleaf.mybatis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.thymeleaf.mybatis.mapper.UserBeanMapper;
import com.thymeleaf.mybatis.pojo.UserBean;
import com.thymeleaf.mybatis.service.UserBeanService;
import com.thymeleaf.mybatis.service.UserService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Package: com.thymeleaf.mybatis.service.impl
 * <p>
 * Author: 懒洋洋
 * <p>
 * Date: Created in 2020/1/9 10:38
 */

/**
 * 配置缓存：当我梦需要缓存的地方越来越多，
 * 可以使用@CacheConfig(cacheName ={})
 */
@CacheConfig(cacheNames = "UserBeanService")
@Service
public class UserBeanServiceImpl implements UserBeanService {

    @Resource
    private UserBeanMapper userBeanMapper;

    /**
     * 配置缓存：注解会先查询是否已经有缓存，会使用缓存，没有则会执行方法并缓存
     * 此处的value是必需的，它指定了你的缓存存放在哪块命令空间
     * keyGenerator：缓存数据时key生成策略
     * @param userName
     * @return
     */
    @Cacheable(value = "getUser",keyGenerator = "keyGenerator")
    @Override
    public UserBean getUser(String userName) {
        QueryWrapper<UserBean> queryWrapper = new QueryWrapper<UserBean>();
        queryWrapper.eq("userName",userName);

        return userBeanMapper.selectOne(queryWrapper);
    }
}
