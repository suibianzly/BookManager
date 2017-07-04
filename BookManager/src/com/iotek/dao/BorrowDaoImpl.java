package com.iotek.dao;

import com.iotek.entity.Borrow;
import com.iotek.until.IoUntils;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/4.
 */
public class BorrowDaoImpl implements BorrowDao {
    private static String path="borrow.txt";
    private ArrayList<Borrow>borrows=new ArrayList<>();
    FileInputStream fis = null;
    ObjectInputStream ois = null;
    FileOutputStream fos = null;
    ObjectOutputStream oos = null;
    public BorrowDaoImpl(){

        try {
            borrows=(ArrayList<Borrow>)IoUntils.load(path, fis, ois).readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        IoUntils.closeAll(fis, ois, fos, oos);



}
}
