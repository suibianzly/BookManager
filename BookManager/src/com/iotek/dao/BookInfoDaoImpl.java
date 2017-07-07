package com.iotek.dao;

import com.iotek.controller.UserController;
import com.iotek.entity.Book;
import com.iotek.entity.BookInfo;
import com.iotek.until.IoUntils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Administrator on 2017/7/1.
 */
public class BookInfoDaoImpl implements BookInfoDao {
    private static String path = "bookinfo.txt";
    //private ArrayList<BookInfo> bookInfos = new ArrayList<>();
    private HashMap<Integer, BookInfo> bookInfosmap = new HashMap<Integer, BookInfo>();
    public BorrowDaoImpl borrowDao = new BorrowDaoImpl();

    FileInputStream fis = null;
    ObjectInputStream ois = null;
    FileOutputStream fos = null;
    ObjectOutputStream oos = null;

    public BookInfoDaoImpl() {
        try {
            bookInfosmap = (HashMap<Integer, BookInfo>) IoUntils.load(path, fis, ois).readObject();
            IoUntils.closeAll(fis, ois, fos, oos);

        } catch (Exception e) {
            //   e.printStackTrace();
        } //catch (ClassNotFoundException e) {
        // }
    }

    public ArrayList<BookInfo> findBookWithBid(int bid) {

        Iterator bifoit = bookInfosmap.keySet().iterator();
        ArrayList<BookInfo> bookInfoList = new ArrayList<BookInfo>();
        while (bifoit.hasNext()) {
            int biid = (int) bifoit.next();
            if (bookInfosmap.get(biid).getBid() == bid) {
                bookInfoList.add(bookInfosmap.get(biid));
            } else {
            }
        }
        return bookInfoList;
    }


    public void addBook(Book book) {
        int addcount = book.getbStock();
        int maxid = getMaxBiid();

        for (int i = 0; i < addcount; i++) {
            BookInfo bookinfo = new BookInfo(book.getbId(), false, false, false);
            bookinfo.setBiid(maxid + i + 1);
            bookInfosmap.put(maxid + i + 1, bookinfo);
        }
        saveBook();
    }

    public int getMaxBiid() {
        Iterator<Integer> biidit = bookInfosmap.keySet().iterator();
        int maxiid = 0;
        while (biidit.hasNext()) {
            int biid = biidit.next();
            if (biid > maxiid) {
                maxiid = biid;
            }
        }
        return maxiid;
    }

    public void saveBook() {
        try {
            IoUntils.save(path, fos, oos).writeObject(bookInfosmap);
            IoUntils.closeAll(fis, ois, fos, oos);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    //展示书本信息
    public void showAllBookInfo() {
        Iterator bifoit = bookInfosmap.keySet().iterator();
        while (bifoit.hasNext()) {
            System.out.println(bookInfosmap.get(bifoit.next()));

        }
    }

    public void delBook(int bid) {
        Iterator bifoit = bookInfosmap.keySet().iterator();
        HashMap<Integer, BookInfo> bookInfosmapTmp = new HashMap<Integer, BookInfo>();
        while (bifoit.hasNext()) {
            int biid = (int) bifoit.next();
            if (bookInfosmap.get(biid).getBid() == bid) {

            } else {
                bookInfosmapTmp.put(biid, bookInfosmap.get(biid));

            }
        }
        bookInfosmap = bookInfosmapTmp;

        saveBook();
    }

    //打印找到的书本信息
    public void showFindedBookInfos(int bid) {

        ArrayList<BookInfo> bookinfolist = findBookWithBid(bid);

        for (int i = 0; i < bookinfolist.size(); i++) {
            System.out.println(bookinfolist.get(i));

        }
    }

    //借书信息
    public void showBorrowMessage() {
        borrowDao.showBorrowMessage();

    }

    public void borrow(int bid, int borrownum, UserController userController) {
        ArrayList<BookInfo> bookinfolist = findBookWithBid(bid);


        for (int i = 0; i < bookinfolist.size(); i++) {

            BookInfo bookinfo = bookinfolist.get(i);
            if (bookinfo.getInout() == false && bookinfo.getLost() == false) {
                bookinfo.setInout(true);
                bookInfosmap.put(bookinfo.getBiid(), bookinfo);
                borrowDao.borrow(userController, bookinfo.getBiid());
                borrownum -= 1;
            }
            if (borrownum == 0) {
                break;
            }

        }
        saveBook();

    }


    public void returnBook(int bid, int returnwnum, UserController userController,boolean Inout, boolean state, boolean Lost) {

        ArrayList<BookInfo> bookinfolist = findBookWithBid(bid);
        for (int i = 0; i < bookinfolist.size(); i++) {

            BookInfo bookinfo = bookinfolist.get(i);
            if (bookinfo.getInout() && !bookinfo.getLost()) {
                bookinfo.setInout(Inout);
                bookinfo.setState(state);
                bookinfo.setLost(Lost);
                bookInfosmap.put(bookinfo.getBiid(), bookinfo);
                borrowDao.returnBook(userController, bookinfo.getBiid());

                returnwnum -= 1;
            }
            if (returnwnum == 0) {
                break;
            }

        }
        saveBook();

    }
}
