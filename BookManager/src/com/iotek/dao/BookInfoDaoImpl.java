package com.iotek.dao;

import com.iotek.entity.BookInfo;
import com.iotek.until.IoUntils;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/1.
 */
public class BookInfoDaoImpl {
    private static String path="bookinfo.txt";
    private ArrayList<BookInfo>bookInfos=new ArrayList<>();
    FileInputStream fis=null;
    ObjectInputStream ois=null;
    FileOutputStream fos=null;
    ObjectOutputStream oos=null;
    public BookInfoDaoImpl(){
        try {
            bookInfos=(ArrayList<BookInfo>) IoUntils.load(path,fis,ois).readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}
