package com.zut.entity;

import java.io.Serializable;

/**
 * (Announ)实体类
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:18
 */
public class Announ implements Serializable {
    private static final long serialVersionUID = -37342101588333602L;
    
    private Integer anId;
    
    private String anTitle;
    
    private String anBody;


    public Integer getAnId() {
        return anId;
    }

    public void setAnId(Integer anId) {
        this.anId = anId;
    }

    public String getAnTitle() {
        return anTitle;
    }

    public void setAnTitle(String anTitle) {
        this.anTitle = anTitle;
    }

    public String getAnBody() {
        return anBody;
    }

    public void setAnBody(String anBody) {
        this.anBody = anBody;
    }

}

