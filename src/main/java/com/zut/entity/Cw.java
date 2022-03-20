package com.zut.entity;

import java.io.Serializable;

/**
 * (Cw)实体类
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:20
 */
public class Cw implements Serializable {
    private static final long serialVersionUID = -34799615846783349L;
    
    private Integer cwId;
    
    private String cwPace;
    
    private String cwType;


    public Integer getCwId() {
        return cwId;
    }

    public void setCwId(Integer cwId) {
        this.cwId = cwId;
    }

    public String getCwPace() {
        return cwPace;
    }

    public void setCwPace(String cwPace) {
        this.cwPace = cwPace;
    }

    public String getCwType() {
        return cwType;
    }

    public void setCwType(String cwType) {
        this.cwType = cwType;
    }

}

