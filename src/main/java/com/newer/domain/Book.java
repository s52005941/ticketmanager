package com.newer.domain;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {
    private int bid;
    private Date  bTime;
    private String uAddress;
    private String bZhifu;
    private Ticket ticket;  //票务id
    private int bNum;
    private int bTotal;
    private Concert concert;  //演唱会id
    private User user;    //用户id
    private int state;  //购票状态 1代表待支付 2代表支付成功

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public Date getbTime() {
        return bTime;
    }

    public void setbTime(Date bTime) {
        this.bTime = bTime;
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    public String getbZhifu() {
        return bZhifu;
    }

    public void setbZhifu(String bZhifu) {
        this.bZhifu = bZhifu;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public int getbNum() {
        return bNum;
    }

    public void setbNum(int bNum) {
        this.bNum = bNum;
    }

    public int getbTotal() {
        return bTotal;
    }

    public void setbTotal(int bTotal) {
        this.bTotal = bTotal;
    }

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bTime=" + bTime +
                ", uAddress='" + uAddress + '\'' +
                ", bZhifu='" + bZhifu + '\'' +
                ", ticket=" + ticket +
                ", bNum=" + bNum +
                ", bTotal=" + bTotal +
                ", concert=" + concert +
                ", user=" + user +
                ", state=" + state +
                '}';
    }
}
