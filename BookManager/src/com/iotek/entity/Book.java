package com.iotek.entity;

import com.iotek.constant.BookType;

import java.io.Serializable;

/**
 * �鱾��
 * Created by Administrator on 2017/6/30.
 */
public class Book implements Serializable {
    private int bId;
    private String bName;
    private int bStock;
    private BookType bType;
    private String author;
    private double price;
    private int discount;
    private int haslended;
    //private int bNumber;

    public Book() {
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

    public int getbStock() {
        return bStock;
    }

    public void setbStock(int bStock) {
        this.bStock = bStock;
    }

    public void addbStock(int bStock) {
        this.bStock += bStock;
     //   addbNumber(bStock);
    }

    public void delbStock(int bStock) {
        this.bStock -= bStock;
    }

    public BookType getbType() {
        return bType;
    }

    public void setbType(BookType bType) {
        this.bType = bType;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getHaslended() {
        return haslended;
    }

    public void setHaslended(int haslended) {
        this.haslended = haslended;
    }

  /*  public void setbNumber(int bNumber){
        this.bNumber=bNumber;
    }
*/
    public void addDiscount(int Discount){
        this.discount+=Discount;
    }

    @Override
    public String toString() {
        return   "书名:" + getbName()+
                " 作者:" + getAuthor() +
                " 剩余数量:" + getbStock()+
                " 价格:" + getPrice()+
                " 类型:" + getbType()+
                " 借出次数:" + getDiscount()+
                " 已借出的数量:" + getHaslended()+
                " 书的ID:" + getbId();
    }

    /*public int getbNumber() {
        return bNumber;

    }*/

    public void borrowStock(int borrownum) {
        delbStock(borrownum);
        addDiscount(borrownum);
        addHaslended(borrownum);
    }

    private void addHaslended(int borrownum) {
        this.haslended+=borrownum;
    }
    private void delHaslended(int borrownum) {
        this.haslended-=borrownum;
    }

    public void returnStock(int returnwnum) {
        addbStock(returnwnum);
        delHaslended(returnwnum);
    }
}