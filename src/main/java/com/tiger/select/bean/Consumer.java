package com.tiger.select.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:zhanglihu
 * @Date:2022/6/19-06-19-22:12
 * @Description:com.tiger.select.bean
 * @Version:1.0
 **/
public class Consumer {
    private Integer consumerid;
    private String consumername;
    private String consumerpwd;
    private String birthday;
    //该用户所具有的订单信息
    private List<Orders> orderList = new ArrayList<>();

    public List<Orders> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Orders> orderList) {
        this.orderList = orderList;
    }

    public Integer getConsumerid() {
        return consumerid;
    }

    public void setConsumerid(Integer consumerid) {
        this.consumerid = consumerid;
    }

    public String getConsumername() {
        return consumername;
    }

    public void setConsumername(String consumername) {
        this.consumername = consumername;
    }

    public String getConsumerpwd() {
        return consumerpwd;
    }

    public void setConsumerpwd(String consumerpwd) {
        this.consumerpwd = consumerpwd;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "consumerid=" + consumerid +
                ", consumername='" + consumername + '\'' +
                ", consumerpwd='" + consumerpwd + '\'' +
                ", birthday='" + birthday + '\'' +
                ", orderList=" + orderList +
                '}';
    }
}
