package com.newer.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * 票务实体类
 */
public class Ticket implements Serializable {
    private Integer tId;       // 编号
    private Concert concert;   // 演唱会
    private Date tSelect;      // 场次
    private float tPrice;      // 价格
    private String tDetails;   // 价格详情
    private Integer tCount;    // 余票

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }

    public Date gettSelect() {
        return tSelect;
    }

    public void settSelect(Date tSelect) {
        this.tSelect = tSelect;
    }

    public float gettPrice() {
        return tPrice;
    }

    public void settPrice(float tPrice) {
        this.tPrice = tPrice;
    }

    public String gettDetails() {
        return tDetails;
    }

    public void settDetails(String tDetails) {
        this.tDetails = tDetails;
    }

    public Integer gettCount() {
        return tCount;
    }

    public void settCount(Integer tCount) {
        this.tCount = tCount;
    }
}
