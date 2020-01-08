package com.thymeleaf.mybatis.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Data
@TableName("sys_role")
public class Role implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long roleId;
    private String roleName;
    private String roleDesc;
    private Integer roleFlag;

    public Role(String roleName, String roleDesc, Integer roleFlag) {
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.roleFlag = roleFlag;
    }

    @TableField(exist = false)
    private Set<User> users = new HashSet<User>();

    public Role() {

    }
}
