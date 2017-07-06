package com.iotek.dao;

import com.iotek.controller.UserController;
import com.iotek.entity.BookInfo;
import com.iotek.entity.Borrow;
import com.iotek.until.IoUntils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Administrator on 2017/7/4.
 */
public class BorrowDaoImpl implements BorrowDao {
    private static String path = "borrow.txt";
    private HashMap<Integer, Borrow> borrowmap = new HashMap<Integer, Borrow>();

    FileInputStream fis = null;
    ObjectInputStream ois = null;
    FileOutputStream fos = null;
    ObjectOutputStream oos = null;

    public BorrowDaoImpl() {
        try {
            borrowmap = (HashMap<Integer, Borrow>) IoUntils.load(path, fis, ois).readObject();
            IoUntils.closeAll(fis, ois, fos, oos);

        } catch (Exception e) {
        }

    }

    public void showBorrowMessage() {
        Iterator borrowit = borrowmap.keySet().iterator();
        while (borrowit.hasNext()) {
            Borrow borrow = borrowmap.get(borrowit.next());
            System.out.println(borrow);

        }
    }


    public void saveBorrow() {
        try {
            IoUntils.save(path, fos, oos).writeObject(borrowmap);
            IoUntils.closeAll(fis, ois, fos, oos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getMaxBorrowId() {
        int maxid = 0;
        Iterator borrowit = borrowmap.keySet().iterator();
        while (borrowit.hasNext()) {
            int id = (int) borrowit.next();
            if (id > maxid) {
                maxid = id;
            }

        }


        return maxid;
    }

    public void borrow(UserController usercontroller, int biid) {
        int uid = usercontroller.user.getuId();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //   System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        String Curremttimestamp = df.format(new Date());
        int borrowid = getMaxBorrowId() + 1;
        Borrow borrow = new Borrow(borrowid, uid, biid, Curremttimestamp);
        borrowmap.put(borrowid, borrow);
        saveBorrow();
    }

    public Borrow findBorrowWithBiidUid(int biid, int uid) {
        int borrowid = 0;
        Iterator borrowit = borrowmap.keySet().iterator();
        while (borrowit.hasNext()) {
            Borrow borrow = borrowmap.get(borrowit.next());
            if (biid == borrow.getBiid() && uid == borrow.getuId() && borrow.getoID() > borrowid && borrow.getReturntime() == null) {
                borrowid = borrow.getoID();
            }

        }
        return borrowmap.get(borrowid);

    }

    public void returnBook(UserController userController, int biid) {
        int uid = userController.user.getuId();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String Curremttimestamp = df.format(new Date());
        Borrow borrow = findBorrowWithBiidUid(biid, uid);
        borrow.setReturntime(Curremttimestamp);
        borrowmap.put(borrow.getoID(), borrow);
        saveBorrow();
    }
}


