package com.iotek.controller;

import com.iotek.dao.UserDaoImpl;
import com.iotek.entity.User;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/7/4.
 */
public class AdminController {
    Scanner sc=new Scanner(System.in);
    UserDaoImpl userDao=new UserDaoImpl();

    private ArrayList<User> users=userDao.getUsers();

    public void print(){
        for(User us:users){
            System.out.println(us.toString());
        }
    }
    public void finduser(){
        System.out.println("请输入要查找的用户名");
        String name=sc.next();
        for(int i=0;i<users.size();i++){
            if(name.equals(users.get(i).getuName())){
                System.out.println(users.get(i));
                break;
            }
        }
    }
    public void topup(){
        System.out.println("请输入用户名");
        String name=sc.next();
        System.out.println("请输入要充值的积分");
        int point=sc.nextInt();
        for(int i=0;i<users.size();i++){
            if(name.equals(users.get(i).getuName())){
                users.get(i).setUpoint(users.get(i).getUpoint() + point);

            }
            System.out.println(users.get(i));
            break;
        }
    }
    public void deduct(){
        System.out.println("请输入用户名");
        String name=sc.next();

        for(int i=0;i<users.size();i++){
            if(name.equals(users.get(i).getuName())){
                System.out.println("请输入要扣除的积分");
                int point=sc.nextInt();
                users.get(i).setUpoint(users.get(i).getUpoint() - point);
                System.out.println(users.get(i));
                break;
            }else{
                System.out.println("无此用户");
            }

        }
    }
    public void deluser(){
        System.out.println("请输入要删除的用户名");
        String name=sc.next();
        for(int i=0;i<users.size();i++){
            if(name.equals(users.get(i).getuName())){
                users.remove(i);
                break;

            }else{
                System.out.println("无此用户");
            }

        }
    }

}
