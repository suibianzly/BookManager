package com.iotek.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/1.
 */
public class BookInfo  implements Serializable {
    private int biid;
    private int bid;
    private boolean inout;
    private boolean state;
    private boolean lost;

    public BookInfo() {
    }

    public BookInfo(int bid, boolean inout, boolean state, boolean lost) {
        // this.id = id;
        this.bid = bid;
        this.inout = inout;
        this.state = state;
        this.lost = lost;
    }

    public int getBiid() {
        return biid;
    }

    public void setBiid(int biid) {
        this.biid = biid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public boolean getInout() {
        return inout;
    }

    public void setInout(boolean inout) {
        this.inout = inout;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean getLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    @Override
    public String toString() {
        return "图书馆书本ID:" + getBiid() +
                " 书表ID:" + getBid() + " 是否在图书馆:" + getInout() +
                " 是否损坏:" + getState() + " 是否丢失:" + getLost();

    }


}
