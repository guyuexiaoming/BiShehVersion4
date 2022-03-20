package com.zut.entity;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:20
 */
public class User implements Serializable {
    private static final long serialVersionUID = -39073315652182699L;
    
    private double userId;
    
    private String userName;
    
    private String userPassword;
    
    private String name;
    
    private String phone;
    
    private String carnumber;


    public double getUserId() {
        return userId;
    }

    public void setUserId(double userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber;
    }

    public String toString(){
        return userId+userName+userPassword+name+phone+carnumber;
    }

}

