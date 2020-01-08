package com.thymeleaf.mybatis.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.thymeleaf.mybatis.mapper.UserMapper;
import com.thymeleaf.mybatis.pojo.User;
import com.thymeleaf.mybatis.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String userName, String password) {
        return userMapper.findByUserName(userName,password);
    }

    @Override
    public void saveUser(User user) {

        if (user.getUserid() != null && user.getUserid() > 0) {
            userMapper.updateById(user);
        } else {
            userMapper.insert(user);
        }
    }

    @Override
    public int deleteUser(Long id) {
        return userMapper.deleteById(id);
    }


    @Override
    public User getUser(Long userId) {
        return userMapper.selectById(userId);
    }

//    @Override
//    public List<User> findAllUsers() {
//        return userMapper.findAllUsers();
//    }


    @Override
    public IPage<User> findUsersMany(String userName, Long roleId, int indexPage) {

        Page<User> page = new Page<User>(indexPage,5);
        QueryWrapper wrapper = new QueryWrapper();

        if (userName != null && !userName.equals("")) {
            wrapper.eq("userName",userName);
        }
        if (roleId > 0) {
            wrapper.eq("userRoleId",roleId);
        }

        return userMapper.selectPageMany(page,wrapper);
    }
}
