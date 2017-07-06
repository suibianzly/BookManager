package com.iotek.entity;

import java.io.Serializable;

/**ԤԼ
 * Created by Administrator on 2017/6/30.
 */
public class Reservation implements Serializable {
    private Integer rId;
    private int uId;
    private int bId;

    public Reservation() {
    }

    public Reservation(Integer rId, int uId, int bId) {
        this.rId = rId;
        this.uId = uId;
        this.bId = bId;
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
}
