package com.tiger.select.bean;

/**
 * @author:zhanglihu
 * @Date:2022/6/19-06-19-23:31
 * @Description:com.tiger.select.bean
 * @Version:1.0
 **/
public class Role {
    private Integer id;
    private String rolename;

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", rolename='" + rolename + '\'' +
                '}';
    }
}
