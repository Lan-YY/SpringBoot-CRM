package com.thymeleaf.mybatis.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.thymeleaf.mybatis.pojo.User;

public interface UserService {
    public User login(String userName, String password);//使用于登录
    public void saveUser(User user); //使用新增和修改
    public int deleteUser(Long id);
    public User getUser(Long userId);
//    public List<User>  findAllUsers();
    // 按条件进行分页查询（动态SQL）
    public IPage<User> findUsersMany(String userName, Long roleId, int indexPage);





}
