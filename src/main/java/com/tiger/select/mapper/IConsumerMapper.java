package com.tiger.select.mapper;

import com.tiger.select.bean.Consumer;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.cache.impl.PerpetualCache;
import org.mybatis.caches.redis.RedisCache;

import java.util.List;

/**
 * @author:zhanglihu
 * @Date:2022/6/19-06-19-23:03
 * @Description:com.tiger.select.mapper
 * @Version:1.0
 **/
@CacheNamespace(implementation = PerpetualCache.class) //开启二级缓存
public interface IConsumerMapper {
    //#查询出全部用户信息以及每个用户对应的订单信息
    public List<Consumer> findAll();
    //注解开发
    @Insert("insert into consumer values(#{consumerid},#{consumername},#{consumerpwd},#{birthday})")
    public void addConsumer(Consumer consumer);
    @Update("update consumer set consumername=#{consumername} where consumerid = #{consumerid}")
    public void updateConsumer(Consumer consumer);
    @Select("select * from consumer")
    public List<Consumer> selectConsumer();
    @Delete("delete from consumer where consumerid =#{consumerid}")
    public void deleteConsumer(Integer id);
    //根据id查询用户
    @Options(useCache = true)//默认true
    @Select("select * from consumer where consumerid=#{consumerid}")
    public Consumer findConsumerById(Integer id);
    @Select("select * from consumer")
    @Results({@Result(property = "consumerid",column = "consumerid"),
            @Result(property = "consumername",column ="consumername" ),
            @Result(property = "consumerpwd",column ="consumerpwd" ),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "orderList",column = "consumerid",javaType = List.class,many = @Many(select = "com.tiger.select.mapper.IOrderMapper.findOrderByConsumerId"))
    })
    public List<Consumer> findAll2();


}
