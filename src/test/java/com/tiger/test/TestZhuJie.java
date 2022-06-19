package com.tiger.test;

import com.tiger.select.bean.Consumer;
import com.tiger.select.mapper.IConsumerMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author:zhanglihu
 * @Date:2022/6/20-06-20-0:11
 * @Description:com.tiger.test
 * @Version:1.0
 **/
public class TestZhuJie {
    private IConsumerMapper consumerMapper;
    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        consumerMapper = sqlSession.getMapper(IConsumerMapper.class);
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
}
