package com.tiger.test;

import com.tiger.bean.User;
import com.tiger.dao.IUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author:zhanglihu
 * @Date:2022/6/19-06-19-17:46
 * @Description:com.tiger.test
 * @Version:1.0
 **/
public class MyBatisTest {
    @Test
    public void test() throws IOException {
        //1、Resources工具类，配置文件的加载，把配置文件加载成字节输入流，现在还没解析
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        //2 解析了配置文件，并创建了sqlSessionFactory工厂
        //解析配文件，封装Configuration对象，创建DefaultSqlSessionFactory对象
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);
        //3 生产sqlSession
        //产生了DefaultSqlSession实例对象，设置了事务不自动提交，完成了executor对象的创建
        SqlSession sqlSession = build.openSession();//默认开启一个事务，但是事务不会自动提交，所有在增删改操作时要手动提交事务
        //4 sqlSession 调用方法 查询所有 selectList 查询单个
        //4.1根据statementid来从Configuration中map集合中获取到了指定的MappedStatement对象
        //4.2将查询任务委派给了executor执行器
        List<User> users = sqlSession.selectList("com.tiger.dao.IUserDao.findAll");
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public void test2() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = build.openSession(true);//事务自动提交
        User user = new User();
        user.setId(4);
        user.setUsername("jack");
        sqlSession.insert("com.tiger.dao.IUserDao.saveUser",user);
        //sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test3() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = build.openSession();
        User user = new User();
        user.setId(3);
        user.setUsername("tom");
        sqlSession.update("com.tiger.dao.IUserDao.updateUser",user);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test4() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = build.openSession();
        sqlSession.delete("com.tiger.dao.IUserDao.deleteUser",4);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test5() throws Exception {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = build.openSession();
        //使用JDK动态代理，对mapper接口产生代理对象
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    /**
     * 动态sql 多条件组合查询 演示if
     * @throws Exception
     */
    @Test
    public void test6() throws Exception {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = build.openSession();
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        User user = new User();
        user.setId(1);
        user.setUsername("tiger");
        List<User> byCondition = mapper.findByCondition(user);
        for (User user1 : byCondition) {
            System.out.println(user1);
        }
    }
    /**
     * 多值查询 演示forEach  sql 片段抽取
     * @throws Exception
     */
    @Test
    public void test7() throws Exception {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = build.openSession();
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        int [] array ={1,2};
        List<User> byCondition = mapper.findByIds(array);
        for (User user1 : byCondition) {
            System.out.println(user1);
        }
    }

}
