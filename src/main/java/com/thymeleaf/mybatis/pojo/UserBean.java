package com.thymeleaf.mybatis.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * Package: com.thymeleaf.mybatis.pojo
 * <p>
 * Author: 懒洋洋
 * <p>
 * Date: Created in 2020/1/9 10:33
 */
@Data
@TableName("sys_user")
public class UserBean implements Serializable {
    @TableId(type = IdType.AUTO)
    @TableField("userId")
    private Long userid;
    @TableField("username")
    private String userName;
    @TableField
    private String password;
    @TableField("userroleid")
    private Long userRoleId;
    @TableField(exist = false)
    private Role role;
    @TableField("userflag")
    private Integer userFlag;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getUserFlag() {
        return userFlag;
    }

    public void setUserFlag(Integer userFlag) {
        this.userFlag = userFlag;
    }
}
