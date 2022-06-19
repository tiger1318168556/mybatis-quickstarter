package com.tiger.select.mapper;

import com.tiger.select.bean.Consumer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author:zhanglihu
 * @Date:2022/6/19-06-19-23:03
 * @Description:com.tiger.select.mapper
 * @Version:1.0
 **/
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

}
