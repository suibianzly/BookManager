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
            System.out.println("用户ID："+us.getuId()+"用户名"+us.getuName()+"用户密码"+us.getuPass()+
                    "用户积分"+us.getUpoint()+"用户等级"+us.getuLevel());
        }
    }

}
