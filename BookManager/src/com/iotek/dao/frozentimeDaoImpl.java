package com.iotek.dao;

import com.iotek.entity.frozentime;
import com.iotek.until.IoUntils;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/4.
 */
public class frozentimeDaoImpl {
    private static String path="frozen.txt";
    ArrayList<frozentime>fro=new ArrayList<>();
    FileInputStream fis=null;
    ObjectInputStream ois=null;
    FileOutputStream fos=null;
    ObjectOutputStream oos=null;
    public frozentimeDaoImpl(){
        try {
            fro=(ArrayList<frozentime>) IoUntils.load(path,fis,ois).readObject();
            IoUntils.closeAll(fis,ois,fos,oos);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
