package com.iotek.view;

import com.iotek.controller.AdminController;
import com.iotek.entity.User;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/7/4.
 */
public class UchangeMenu {
    Scanner sc=new Scanner(System.in);
    private User user=new User();
    private String uName;
    private String uPass;
    private String uSex;
    private Integer uAge;
    private Integer uLevel;
    private int upoint;
    public void uMenu(AdminController adminController){
//        System.out.println("请输入要修改的用户名");
//        String name=sc.next();
//        int index=adminController.find();
        boolean falg=true;
        while (true){
            System.out.println("请选择要修改的类型");
            System.out.println("1 用户名");
            System.out.println("2 密码");
            System.out.println("3 性别");
            System.out.println("4 年龄");
            System.out.println("5 等级");
            System.out.println("6 积分");
            System.out.println("0 返回上一层");
            String key=sc.next();
            switch (key){
                case "1":adminController.amendname();
                    break;
                case "2":adminController.amendpass();
                    break;
                case "3":adminController.amendsex();
                    break;
                case "4":adminController.amendage();
                    break;
                case "5":adminController.amendlevel();
                    break;
                case "6":adminController.amendpoint();
                    break;
                case "0":
                    falg=false;
                    return;
            }

        }





    }

}
