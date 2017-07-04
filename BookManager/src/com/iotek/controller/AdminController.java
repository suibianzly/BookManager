package com.iotek.controller;

import com.iotek.dao.UserDaoImpl;
import com.iotek.entity.User;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/4.
 */
public class AdminController {

    UserDaoImpl userDao=new UserDaoImpl();

    private ArrayList<User> users=userDao.getUsers();

    public void print(){
        for(User us:users){
            System.out.println(us);
        }
    }

}
