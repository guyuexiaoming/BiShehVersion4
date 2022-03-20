package com.zut.entity;

import java.io.Serializable;

/**
 * (P)实体类
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:20
 */
public class P implements Serializable {
    private static final long serialVersionUID = -28724854108319238L;
    
    private Integer pId;
    
    private String pName;
    
    private String pPassword;
    
    private String pPhone;


    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public String getPPassword() {
        return pPassword;
    }

    public void setPPassword(String pPassword) {
        this.pPassword = pPassword;
    }

    public String getPPhone() {
        return pPhone;
    }

    public void setPPhone(String pPhone) {
        this.pPhone = pPhone;
    }

}

