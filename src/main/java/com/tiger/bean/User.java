package com.tiger.bean;

import com.tiger.select.bean.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:zhanglihu
 * @Date:2022/6/19-06-19-12:01
 * @Description:com.tiger.bean
 * @Version:1.0
 **/
public class User {
    private Integer id;
    private String username;

    private List<Role> roleList = new ArrayList<>();

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", roleList=" + roleList +
                '}';
    }
}
