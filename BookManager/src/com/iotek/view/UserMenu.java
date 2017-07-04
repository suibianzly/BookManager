package com.iotek.view;

import com.iotek.controller.UserController;
import com.iotek.entity.User;

import java.util.Scanner;

/**
 * Created by hexiang on 2017/6/7.
 */
public class UserMenu {
    //UserController userControllers=new UserController();
    Scanner scanner = new Scanner(System.in);

    //User user1=null;
    public void usMenu(UserController userController) throws Exception {
        // user1=user;
        boolean flag = true;
        while (flag) {
            System.out.println("1.查看个人信息");
            System.out.println("2.查看图书信息");
            System.out.println("3.借书");
            System.out.println("4.还书");
            System.out.println("5.退出");
            System.out.println("-------------");
            System.out.println("请选择：");
            int choose = 0;
            try {
                choose = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("请输入数字");
            }
            switch (choose) {
                case 1:
                    userController.checkPersonalInfo();
                    break;
                case 2:
                    userController.checkBookinfo();
                    break;
                case 3:
                    userController.Borrow();
                    break;
                case 4:
                    userController.returnBook();
                    break;
                case 5:
                    flag=false;
                    break;
                default:
                    break;
            }


        }
    }
}