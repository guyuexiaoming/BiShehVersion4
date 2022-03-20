package com.zut.entity;

import java.io.Serializable;

/**
 * (Orders)实体类
 *
 * @author 古月小白
 * @since 2022-03-11 17:40:59
 */
public class Orders implements Serializable {
    private static final long serialVersionUID = -89107556141590541L;
    
    private Integer userId;
    
    private String cwId;
    
    private Integer ordersId;
    
    private Integer ordersMoney;
    
    private String ordersTime;
    
    private String ordersEval;

    private String ordersStatus;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCwId() {
        return cwId;
    }

    public void setCwId(String cwId) {
        this.cwId = cwId;
    }

    public Integer getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    public Integer getOrdersMoney() {
        return ordersMoney;
    }

    public void setOrdersMoney(Integer ordersMoney) {
        this.ordersMoney = ordersMoney;
    }

    public String getOrdersTime() {
        return ordersTime;
    }

    public void setOrdersTime(String ordersTime) {
        this.ordersTime = ordersTime;
    }

    public String getOrdersEval() {
        return ordersEval;
    }

    public void setOrdersEval(String ordersEval) {
        this.ordersEval = ordersEval;
    }

    public String getOrdersStatus() {
        return ordersStatus;
    }

    public void setOrdersStatus(String ordersStatus) {
        this.ordersStatus = ordersStatus;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "userId=" + userId +
                ", cwId='" + cwId + '\'' +
                ", ordersId=" + ordersId +
                ", ordersMoney=" + ordersMoney +
                ", ordersTime='" + ordersTime + '\'' +
                ", ordersEval='" + ordersEval + '\'' +
                ", ordersStatus='" + ordersStatus + '\'' +
                '}';
    }
}

