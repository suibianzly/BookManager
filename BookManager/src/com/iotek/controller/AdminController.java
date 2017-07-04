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
            userDao.SaveUser(users);
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
    public int find(){
        System.out.println("请输入要修改的用户名");
        String name=sc.next();
        int index=-1;
        for(int i=0;i<users.size();i++){
            if(name.equals(users.get(i).getuName())){
                index=i;
                break;
            }
        }return index;
    }
    public void amendname(){
        int index=find();
        System.out.println("请输入要更正的用户名");
        String name=sc.next();
        users.get(index).setuName(name);
        System.out.println(users.get(index));
    }
    public void amendpass(){
        int index=find();
        System.out.println("请输入要更正的用户密码");
        String pass=sc.next();
        users.get(index).setuPass(pass);
        System.out.println(users.get(index));
    }
    public void amendsex(){
        int index=find();
        System.out.println("请输入要更正的用户性别");
        String sex=sc.next();
        users.get(index).setuSex(sex);
        System.out.println(users.get(index));
    }
    public void amendage(){
        int index=find();
        System.out.println("请输入要更正的用户年龄");
        int age=sc.nextInt();
        users.get(index).setuAge(age);
        System.out.println(users.get(index));
    }
    public void amendlevel(){
        int index=find();
        System.out.println("请输入要更正的用户等级");
        int level=sc.nextInt();
        users.get(index).setuLevel(level);
        System.out.println(users.get(index));
    }
    public void amendpoint(){
        int index=find();
        System.out.println("请输入要更正的用户等级");
        int point=sc.nextInt();
        users.get(index).setUpoint(point);
        System.out.println(users.get(index));

    }



}
