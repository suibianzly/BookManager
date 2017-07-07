package com.iotek.view;

import com.iotek.controller.UserController;
import com.iotek.dao.ReservtionDaoImpl;
import com.iotek.entity.Reservation;
import com.iotek.entity.User;

import java.util.Scanner;

/**
 * Created by hexiang on 2017/6/7.
 */
public class UserMenu {
    //UserController userControllers=new UserController();
    Scanner scanner = new Scanner(System.in);


    public int ReadMoney(int point) {
        int Money = 0;
        boolean flag = true;
        while (flag) {
            System.out.println("请输入充值金额");

            try {
                scanner = new Scanner(System.in);
                flag = true;
                Money = scanner.nextInt();
                flag = false;
                if (Money < point) {
                    System.out.println("请至少充值" + point + "元");
                    flag = true;
                }

            } catch (Exception e) {
                System.out.println("充值金额不是数字");
                //System.out.println("请重新输入");

            }
        }
        return Money;
    }

    //User user1=null;
    public void usMenu(UserController userController) throws Exception {
        // user1=user;
        if (userController.user.getUpoint() <= 0) {

            int point = 10 - userController.user.getUpoint();
            System.out.println("账户已被冻结，是否充值解冻,请至少充值" + point + "元:是/否");
            String yn = scanner.next();
            if (yn.equals("是")) {

                int money = ReadMoney(point);
                userController.user.setUpoint(userController.user.getUpoint() + money);
                userController.userDaoImpl.changeUser(userController.user);
                usMenu(userController);
            } else {
                return;
            }


        } else {


            boolean flag = true;
            while (flag) {
                System.out.println("1.查看个人信息");
                System.out.println("2.查看图书信息");
                System.out.println("3.借书");
                System.out.println("4.还书");
                System.out.println("5.书籍租借预约");
                System.out.println("0.退出");
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
                        ReservtionDaoImpl reservtionDao = new ReservtionDaoImpl();
                        reservtionDao.addReservtion(userController);

                        break;
                    case 0:
                        flag = false;
                        break;
                    default:
                        break;
                }


            }
        }
    }
}