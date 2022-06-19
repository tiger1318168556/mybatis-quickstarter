package com.tiger.select.mapper;

import com.tiger.select.bean.Orders;

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
}
