package com.iotek.constant;

/**
 * Created by Administrator on 2017/7/2.
 */
public enum BookType {
   教育("教育"),
    小说("小说"),
    文艺("文艺"),
    童书("童书"),
    生活("生活"),
    人文社科("人文社科"),
    经管("经管"),
    科技("科技");

    public String type;
    private BookType(String btype) {
        this.type=btype;

    }
}
