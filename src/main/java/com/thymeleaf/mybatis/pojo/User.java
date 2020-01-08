package com.thymeleaf.mybatis.pojo;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.annotations.Many;

@Data
@TableName("sys_user")
public class User {
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

    public User(String userName, String password, Role role, Integer userFlag) {
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.userFlag = userFlag;
    }

    public User() {

    }
}
