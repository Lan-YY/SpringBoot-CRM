package com.thymeleaf.mybatis.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.thymeleaf.mybatis.pojo.Role;
import com.thymeleaf.mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;

import java.util.List;

/**
 * Package: com.thymeleaf.mapper
 * <p>
 * Description： TODO
 * <p>
 * Author: 作者
 * <p>
 * Date: Created in 2020/1/4 17:35
 * <p>
 * Company: 公司
 * <p>
 * Copyright: Copyright (c) 2017
 * <p>
 * Version: 0.0.1
 * <p>
 * Modified By:
 */
public interface RoleMapper extends BaseMapper<Role> {


    public List<Role> findAllRoles();
}
