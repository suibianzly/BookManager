package com.iotek.view;

import com.iotek.controller.AdminController;
import com.iotek.entity.User;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/7/4.
 */
public class UsermanagerMenu {
    public void usmm(AdminController adminController,ArrayList<User>users){
        Scanner sc=new Scanner(System.in);

        boolean falg=true;
        while (falg){
            System.out.println("1  查看用户");
            System.out.println("2  查找用户");
            System.out.println("3  积分充值");
            System.out.println("4  积分扣除");
            System.out.println("5  账户冻结");
            System.out.println("6  删除用户");
            System.out.println("7  用户信息修改");
            System.out.println("0  返回上层");
            String key=sc.next();
            switch (key){
                case "1":
                    adminController.print(users);
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    break;
                case "0":
                    return;
                default:
                    return;
            }

        }
    }
}
