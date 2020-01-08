package com.thymeleaf.mybatis.mapper;




import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.thymeleaf.mybatis.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    @Results(id = "userByRole" ,value = {
            @Result(property = "role",column = "userRoleId",one = @One(select = "com.thymeleaf.mybatis.mapper.RoleMapper.selectById"))
    })
    @Select("select * from sys_user")
    public List<User>  findAllUsers();


    @Select("select * from sys_user where userName =#{userName} and password = #{password}")
    public User findByUserName(@Param("userName") String userName, @Param("password") String password);

    @ResultMap(value = "userByRole")
    @Select("select * from sys_user ${ew.customSqlSegment}")
    public IPage<User> selectPageMany(Page page,@Param("ew") Wrapper wrapper);
}
