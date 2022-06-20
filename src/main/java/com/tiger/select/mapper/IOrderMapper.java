package com.tiger.select.mapper;

import com.tiger.select.bean.Consumer;
import com.tiger.select.bean.Orders;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author:zhanglihu
 * @Date:2022/6/19-06-19-22:23
 * @Description:com.tiger.select.mapper
 * @Version:1.0
 **/
public interface IOrderMapper {
    //查询订单的同时还查询该订单所属的用户
    public List<Orders> findOrderAndConsumer();

    /**
     * 注解开发
     * @return
     */
    @Results({@Result(property = "orderid",column ="orderid" ),
            @Result(property = "ordertime",column = "ordertime"),
    @Result(property = "total",column = "total"),//@One(select = "namespace.id") column="consumerid" 就是传入的参数
    @Result(property = "consumer",column = "consumerid",javaType = Consumer.class,one=@One(select = "com.tiger.select.mapper.IConsumerMapper.findConsumerById"))})
    @Select("select * from orders")
    public List<Orders> findOrderAndConsumers();
}
