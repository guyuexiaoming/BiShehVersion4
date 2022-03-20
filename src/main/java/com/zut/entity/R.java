package com.zut.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (R)实体类
 *
 * @author 古月小白
 * @since 2022-03-13 08:06:32
 */
public class R implements Serializable {
    private static final long serialVersionUID = 471005655228431190L;
    
    private Integer rId;
    
    private Integer pId;
    
    private Integer cwId;
    
    private Date rTime;
    
    private String rName;
    
    private Integer rMoney;
    
    private String rOpinion;


    public Integer getRId() {
        return rId;
    }

    public void setRId(Integer rId) {
        this.rId = rId;
    }

    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }

    public Integer getCwId() {
        return cwId;
    }

    public void setCwId(Integer cwId) {
        this.cwId = cwId;
    }

    public Date getRTime() {
        return rTime;
    }

    public void setRTime(Date rTime) {
        this.rTime = rTime;
    }

    public String getRName() {
        return rName;
    }

    public void setRName(String rName) {
        this.rName = rName;
    }

    public Integer getRMoney() {
        return rMoney;
    }

    public void setRMoney(Integer rMoney) {
        this.rMoney = rMoney;
    }

    public String getROpinion() {
        return rOpinion;
    }

    public void setROpinion(String rOpinion) {
        this.rOpinion = rOpinion;
    }

}

