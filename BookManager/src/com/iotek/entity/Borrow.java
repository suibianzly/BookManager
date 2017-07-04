package com.iotek.entity;

import java.io.Serializable;

/**½è»¹
 * Created by Administrator on 2017/6/30.
 */
public class Borrow implements Serializable {
    private Integer oID;
    private int uId;
    private int biid;
    private int oStock;
    private String lendtime;
    private String returntime;

    public Borrow() {
    }

    public Borrow(Integer oID, int uId, int biid, int oStock, String lendtime, String returntime) {
        this.oID = oID;
        this.uId = uId;
        this.biid = biid;
        this.oStock = oStock;
        this.lendtime = lendtime;
        this.returntime = returntime;
    }

    public Integer getoID() {
        return oID;
    }

    public void setoID(Integer oID) {
        this.oID = oID;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getBiid() {
        return biid;
    }

    public void setBiid(int biid) {
        this.biid = biid;
    }

    public int getoStock() {
        return oStock;
    }

    public void setoStock(int oStock) {
        this.oStock = oStock;
    }

    public String getLendtime() {
        return lendtime;
    }

    public void setLendtime(String lendtime) {
        this.lendtime = lendtime;
    }

    public String getReturntime() {
        return returntime;
    }

    public void setReturntime(String returntime) {
        this.returntime = returntime;
    }
}
