package com.zut.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Carmate)实体类
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:20
 */
public class Carmate implements Serializable {
    private static final long serialVersionUID = -76512891112867475L;
    
    private Integer carId;
    
    private String carNumber;
    
    private Integer coupon;
    
    private Date inTime;
    
    private Date outTime;
    
    private Integer costmoney;


    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Integer getCoupon() {
        return coupon;
    }

    public void setCoupon(Integer coupon) {
        this.coupon = coupon;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public Integer getCostmoney() {
        return costmoney;
    }

    public void setCostmoney(Integer costmoney) {
        this.costmoney = costmoney;
    }

}

