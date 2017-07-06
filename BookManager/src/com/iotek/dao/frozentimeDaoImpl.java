package com.iotek.dao;

import com.iotek.controller.UserController;
import com.iotek.entity.Frozentime;
import com.iotek.until.IoUntils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/7/4.
 */
public class FrozentimeDaoImpl {
    private static String path="frozen.txt";
    ArrayList<Frozentime>fro=new ArrayList<>();
    FileInputStream fis=null;
    ObjectInputStream ois=null;
    FileOutputStream fos=null;
    ObjectOutputStream oos=null;
    public FrozentimeDaoImpl(){
        try {
            fro=(ArrayList<Frozentime>) IoUntils.load(path,fis,ois).readObject();
            IoUntils.closeAll(fis,ois,fos,oos);
        } catch (IOException e) {
           // e.printStackTrace();
        } catch (ClassNotFoundException e) {
           // e.printStackTrace();
       }

    }
    public void saveFrozentime(){
        try {
            IoUntils.save(path, fos, oos).writeObject(fro);
            IoUntils.closeAll(fis, ois, fos, oos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int Maxid(){
        int maxid=0;
        if (fro.size() > 0) {
            for (int i = 0; i < fro.size(); i++) {
                if (fro.get(i) != null && maxid < fro.get(i).getfId()) {
                    maxid = fro.get(i).getuId();
                }
            }

        }return maxid;

    }
    public void frozentime(UserController userController){
        int uId=userController.user.getuId();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String frozentimestamp = df.format(new Date());
        int fId=Maxid()+1;
        Frozentime frozentime=new Frozentime(fId,uId,frozentimestamp,null);
        fro.add(frozentime);
        saveFrozentime();
    }
    public void unfrozentime(UserController userController,int uId){
        Scanner sc=new Scanner(System.in);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String unfrozentimestamp = df.format(new Date());
        System.out.println("请输入要解冻用户ID");
        int uid=sc.nextInt();
        for(int i=0;i<fro.size();i++){
            if(uid==uId){fro.get(i).setUnfrozentime(unfrozentimestamp);

            }break;
        }
    }

}
