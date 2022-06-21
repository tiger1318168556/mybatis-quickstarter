package com.tiger.test;

import com.tiger.select.bean.Consumer;
import com.tiger.select.mapper.IConsumerMapper;
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
 * @Date:2022/6/21-06-21-20:33
 * @Description:com.tiger.test
 * @Version:1.0
 **/
public class TestPlugin {
    @Test
    public  void testPlugin() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IConsumerMapper mapper = sqlSession.getMapper(IConsumerMapper.class);
        List<Consumer> consumers = mapper.selectConsumer();
        for (Consumer consumer : consumers) {
            System.out.println(consumer);
        }
    }
}
