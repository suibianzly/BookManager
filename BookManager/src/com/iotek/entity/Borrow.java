package com.iotek.entity;

import java.io.Serializable;

/**½è»¹
 * Created by Administrator on 2017/6/30.
 */
public class Borrow implements Serializable {
    private Integer oID;
    private int uId;
    private int biid;
    private String lendtime;
    private String returntime;

    public Borrow() {
    }

    public Borrow(Integer oID,int uId,  int biid,  String lendtime) {
        this.uId=uId;
        this.oID = oID;
        this.biid = biid;
        this.lendtime = lendtime;

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

    @Override
    public String toString() {
        return "Borrow{" +
                "oID=" + oID +
                ", uId=" + uId +
                ", biid=" + biid +
                ", lendtime='" + lendtime + '\'' +
                ", returntime='" + returntime + '\'' +
                '}';
    }
}
