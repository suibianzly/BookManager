package com.iotek.entity;

/**
 * Created by Administrator on 2017/7/4.
 */
public class frozentime {
    private int fId;
    private int uId;
    private String frozentime;
    private String unfrozentime;

    public frozentime() {
    }

    public frozentime(int fId, int uId, String frozentime, String unfrozentime) {
        this.fId = fId;
        this.uId = uId;
        this.frozentime = frozentime;
        this.unfrozentime = unfrozentime;
    }

    public int getfId() {
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getFrozentime() {
        return frozentime;
    }

    public void setFrozentime(String frozentime) {
        this.frozentime = frozentime;
    }

    public String getUnfrozentime() {
        return unfrozentime;
    }

    public void setUnfrozentime(String unfrozentime) {
        this.unfrozentime = unfrozentime;
    }
}
