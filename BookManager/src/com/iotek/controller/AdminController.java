package com.iotek.controller;

import com.iotek.dao.UserDaoImpl;
import com.iotek.entity.User;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/4.
 */
public class AdminController {
    private ArrayList<User>users;

    public void print(ArrayList<User>users){
        for(User us:users){
            System.out.println("�û�ID��"+us.getuId()+"�û���"+us.getuName()+"�û�����"+us.getuPass()+
                    "�û�����"+us.getUpoint()+"�û��ȼ�"+us.getuLevel());
        }
    }

}
