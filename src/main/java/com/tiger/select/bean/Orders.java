package com.tiger.select.bean;

/**
 * @author:zhanglihu
 * @Date:2022/6/19-06-19-22:13
 * @Description:com.tiger.select.bean
 * @Version:1.0
 **/
public class Orders {
    private Integer orderid;
    private String ordertime;
    private Double total;
    //该订单属于哪个用户
    private Consumer consumer;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderid=" + orderid +
                ", ordertime='" + ordertime + '\'' +
                ", total=" + total +
                ", consumer=" + consumer +
                '}';
    }
}
