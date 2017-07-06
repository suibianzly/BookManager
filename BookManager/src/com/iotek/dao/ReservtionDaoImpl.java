package com.iotek.dao;

import com.iotek.controller.BookControllerTest;
import com.iotek.controller.UserController;
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
    FileInputStream fis=null;
    ObjectInputStream ois=null;
    FileOutputStream fos=null;
    ObjectOutputStream oos=null;
    public ReservtionDaoImpl(){

        try {
            res=(ArrayList<Reservation>) IoUntils.load(path,fis,ois).readObject();
            IoUntils.closeAll(fis,ois,fos,oos);
        } catch (IOException e) {
           // e.printStackTrace();
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
        }


    }
    public void saveReservation(){
        try {
            IoUntils.save(path, fos, oos).writeObject(res);
            IoUntils.closeAll(fis, ois, fos, oos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int Maxid(){
        int maxid=0;
        if (res.size() > 0) {
            for (int i = 0; i < res.size(); i++) {
                if (res.get(i) != null && maxid < res.get(i).getrId()) {
                    maxid = res.get(i).getuId();
                }
            }

        }return maxid;

    }
    public void addReservtion(UserController userController,BookControllerTest bookControllerTest){
        int rId=Maxid()+1;
        int uId=userController.user.getuId();
        int bId=bookControllerTest.book.getbId();
        Reservation reservation=new Reservation(rId,uId,bId);
        saveReservation();
    }

}
