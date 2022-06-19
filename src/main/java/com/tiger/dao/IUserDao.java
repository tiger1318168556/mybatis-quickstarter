package com.tiger.dao;

import com.tiger.bean.User;
import com.tiger.select.bean.Role;

import java.util.List;

/**
 * @author:zhanglihu
 * @Date:2022/6/19-06-19-14:33
 * @Description:com.tiger.dao
 * @Version:1.0
 **/
public interface IUserDao {
    //查询所有用户
    List<User> findAll() throws Exception;
    //新增用户
    void saveUser(User user) throws Exception;
    //修改用户
    void updateUser(User user) throws Exception;
    //删除用户
    void deleteUser(Integer id) throws Exception;
    //多条件组合查询，演示if
    public List<User> findByCondition(User user) throws Exception;
    //多值查询 演示forEach
    public List<User> findByIds(int [] ids) throws Exception;
    //#查询用户以及对应的角色
    public List<User> findAllUserAndRole();

}
