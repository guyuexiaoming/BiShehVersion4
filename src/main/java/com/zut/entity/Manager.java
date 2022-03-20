package com.zut.entity;

import java.io.Serializable;

/**
 * (Manager)实体类
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:20
 */
public class Manager implements Serializable {
    private static final long serialVersionUID = 229005888056232506L;
    
    private String username;
    
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

