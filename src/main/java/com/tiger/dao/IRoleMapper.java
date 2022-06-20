package com.tiger.dao;

import com.tiger.select.bean.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author:zhanglihu
 * @Date:2022/6/20-06-20-22:16
 * @Description:com.tiger.dao
 * @Version:1.0
 **/
public interface IRoleMapper {
    @Select("select * from role r, user_role ur where r.id = ur.roleid and ur.userid=#{userid}")
    public List<Role> findRoleByUserId(Integer userid);
}
