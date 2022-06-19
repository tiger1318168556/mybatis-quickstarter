package com.tiger.test;

import com.tiger.select.bean.Consumer;
import com.tiger.select.mapper.IConsumerMapper;
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
 * @Date:2022/6/19-06-19-23:11
 * @Description:com.tiger.test
 * @Version:1.0
 **/
public class TestOneToMany {
    @Test
    public void test() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IConsumerMapper mapper = sqlSession.getMapper(IConsumerMapper.class);
        List<Consumer> all = mapper.findAll();
        for (Consumer consumer : all) {
            System.out.println(consumer);
            System.out.println(consumer.getOrderList());
            System.out.println("----------");
        }


    }
}
