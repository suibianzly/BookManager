package com.iotek.dao;

import com.iotek.entity.Reservation;
import com.iotek.until.IoUntils;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/4.
 */
public class ReservtionDaoImpl {
    private ArrayList<Reservation>res=new ArrayList<>();
    private String path="reservation.txt";
    public ReservtionDaoImpl(){
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try {
            res=(ArrayList<Reservation>) IoUntils.load(path,fis,ois).readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        IoUntils.closeAll(fis,ois,fos,oos);

    }
}
