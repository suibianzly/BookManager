package com.iotek.entity;

/**
 * Created by Administrator on 2017/7/1.
 */
public class BookInfo {
    private int id;
    private int bid;
    private String inout;
    private String state;
    private String lost;

    public BookInfo() {
    }

    public BookInfo(int id, int bid, String inout, String state, String lost) {
        this.id = id;
        this.bid = bid;
        this.inout = inout;
        this.state = state;
        this.lost = lost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getInout() {
        return inout;
    }

    public void setInout(String inout) {
        this.inout = inout;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLost() {
        return lost;
    }

    public void setLost(String lost) {
        this.lost = lost;
    }
}
