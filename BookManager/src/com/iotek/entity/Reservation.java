package com.iotek.entity;

import java.io.Serializable;

/**ԤԼ
 * Created by Administrator on 2017/6/30.
 */
public class Reservation implements Serializable {
    private Integer rId;
    private int uId;
    private int bId;
    private String bName;
    private int rStock;
    private String rDate;

    public Reservation() {
    }

    public Reservation(Integer rId, int uId, int bId, String bName, int rStock, String rDate) {
        this.rId = rId;
        this.uId = uId;
        this.bId = bId;
        this.bName = bName;
        this.rStock = rStock;
        this.rDate = rDate;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public int getrStock() {
        return rStock;
    }

    public void setrStock(int rStock) {
        this.rStock = rStock;
    }

    public String getrDate() {
        return rDate;
    }

    public void setrDate(String rDate) {
        this.rDate = rDate;
    }
}
