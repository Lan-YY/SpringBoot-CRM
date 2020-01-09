package com.thymeleaf.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.thymeleaf.mybatis.pojo.UserBean;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;

/**
 * Package: com.thymeleaf.mybatis.mapper
 * <p>
 * Author: 懒洋洋
 * <p>
 * Date: Created in 2020/1/9 10:35
 */
//@CacheNamespace(implementation= MybatisRedisCache.class,eviction=MybatisRedisCache.class)
public interface UserBeanMapper extends BaseMapper<UserBean> {


}
