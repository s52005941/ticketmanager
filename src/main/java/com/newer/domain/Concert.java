package com.newer.domain;

import java.io.Serializable;

/**
 * 演唱会实体类
 */
public class Concert implements Serializable {
    private Integer cId;     // 编号
    private String cTitle;   // 标题
    private String cAddr;    // 场馆
    private String cCover;   // 图片
    private String cContent; // 介绍

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcTitle() {
        return cTitle;
    }

    public void setcTitle(String cTitle) {
        this.cTitle = cTitle;
    }

    public String getcAddr() {
        return cAddr;
    }

    public void setcAddr(String cAddr) {
        this.cAddr = cAddr;
    }

    public String getcCover() {
        return cCover;
    }

    public void setcCover(String cCover) {
        this.cCover = cCover;
    }

    public String getcContent() {
        return cContent;
    }

    public void setcContent(String cContent) {
        this.cContent = cContent;
    }
}
