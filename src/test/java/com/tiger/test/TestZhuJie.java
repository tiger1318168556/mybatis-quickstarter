package com.tiger.test;

import com.tiger.bean.User;
import com.tiger.dao.IUserDao;
import com.tiger.select.bean.Consumer;
import com.tiger.select.bean.Orders;
import com.tiger.select.mapper.IConsumerMapper;
import com.tiger.select.mapper.IOrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author:zhanglihu
 * @Date:2022/6/20-06-20-0:11
 * @Description:com.tiger.test
 * @Version:1.0
 **/
public class TestZhuJie {
    private IConsumerMapper consumerMapper;
    private IOrderMapper orderMapper;
    private IUserDao userDao;
    private SqlSession sqlSession;
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession(false);
        consumerMapper = sqlSession.getMapper(IConsumerMapper.class);
        orderMapper = sqlSession.getMapper(IOrderMapper.class);
        userDao = sqlSession.getMapper(IUserDao.class);
    }
    @Test
    public void addConsumer(){
        Consumer consumer = new Consumer();
        consumer.setConsumerid(5);
        consumer.setConsumername("苍井空");
        consumer.setConsumerpwd("123");
        consumer.setBirthday("1989-03-23");
        consumerMapper.addConsumer(consumer);
    }

    @Test//测试注解开发
    public void test2OneToOneZhuJie() throws IOException {
        List<Orders> orderAndConsumers = orderMapper.findOrderAndConsumers();
        for (Orders orderAndConsumer : orderAndConsumers) {
            System.out.println(orderAndConsumer);
        }
    }

    @Test//测试注解开发
    public void test2OneToManyZhuJie() throws IOException {
        List<Consumer> all2 = consumerMapper.findAll2();
        for (Consumer consumer : all2) {
            System.out.println(consumer);
        }
    }
    @Test//测试注解开发
    public void test2ManyToManyZhuJie() throws IOException {
        List<User> allUserAndRole2 = userDao.findAllUserAndRole2();
        for (User user : allUserAndRole2) {
            System.out.println(user);
        }
    }
    //MyBatis缓存
    @Test
    public void testFirstLevelCache(){
        //第一次查询id为1 的客户 首先是去一级缓存中查询，有：直接返回
        //没有：查询数据库，同时将查询出的结果存到一级缓存中
        Consumer consumerById = consumerMapper.findConsumerById(1);
        //更新consumer,对以及缓存进行刷新
        //结论：做增删改操作，并进行了事务提交，就是刷新一级缓存
        Consumer consumer =new Consumer();
        consumer.setConsumerid(1);
        consumer.setConsumername("波多野结衣");
        consumerMapper.updateConsumer(consumer);
        sqlSession.commit();
        sqlSession.clearCache();//清空一级缓存，手动刷新缓存
        //第二次查询id为1 的客户
        //首先是去一级缓存中查询数据，有：直接返回
        //没有：查询数据库，同时将查询出来的数据结果存放到一级缓存中
        Consumer consumerById1 = consumerMapper.findConsumerById(1);
        System.out.println(consumerById==consumerById1);
    }

    @Test
    public void secondCacheLevelTest(){
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();
        IConsumerMapper mapper1 = sqlSession1.getMapper(IConsumerMapper.class);
        IConsumerMapper mapper2 = sqlSession2.getMapper(IConsumerMapper.class);
        IConsumerMapper mapper3 = sqlSession3.getMapper(IConsumerMapper.class);
        Consumer consumerById1 = mapper1.findConsumerById(1);
        sqlSession1.close();//清空一级缓存
        //sqlSession1.commit();
        //更新操作
        Consumer consumer = new Consumer();
        consumer.setConsumerid(1);
        consumer.setConsumername("夏栀");
        mapper3.updateConsumer(consumer);
        sqlSession3.commit();//清空二级缓存
        Consumer consumerById2 = mapper2.findConsumerById(1);
        System.out.println(consumerById1 == consumerById2);//false 二级缓存缓存的是对象中的数据，并不是对象，在第二去查询对象时，为我们重新创建了一个consumer对象
        //并且把二级缓存中提前缓存好的数据重新封装成这个对象


    }
}
