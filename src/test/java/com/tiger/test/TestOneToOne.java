package com.tiger.test;

import com.tiger.select.bean.Orders;
import com.tiger.select.mapper.IOrderMapper;
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
 * @Date:2022/6/19-06-19-22:39
 * @Description:com.tiger.test
 * @Version:1.0
 **/
public class TestOneToOne {
    @Test
    public void test() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IOrderMapper mapper = sqlSession.getMapper(IOrderMapper.class);
        List<Orders> orderAndConsumer = mapper.findOrderAndConsumer();
        for (Orders orders : orderAndConsumer) {
            System.out.println(orders);
        }

    }
}
