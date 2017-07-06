package com.iotek.view;

import com.iotek.controller.AdminController;
import com.iotek.controller.BookControllerTest;
import com.iotek.dao.BorrowDaoImpl;
import com.iotek.entity.User;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by hexiang on 2017/6/7.
 */
public class ManagerMenu {
  //  BookControllerTest bookControllerTest;
    AdminController adminController = new AdminController();
   // BorrowDaoImpl borrowDao = new BorrowDaoImpl();
   // ArrayList<User> users;
    Scanner scanner = new Scanner(System.in);

    public void managerMenu(BookControllerTest bookControllerTest) throws Exception {
       // this.bookControllerTest = bookControllerTest;
        int choose = 0;
        boolean keeploop = true;
        while (keeploop == true) {
            System.out.println("1.管理图书");
            //System.out.println("2.查看借书记录");
            System.out.println("3.管理用户");
            System.out.println("0.退出");
            System.out.println("-------------");
            System.out.println("请选择：");

            try {
                choose = scanner.nextInt();
            } catch (Exception e) {
                e.printStackTrace();
            }
            switch (choose) {
                case 1:
                    BookMenu bookMenu = new BookMenu();
                    bookMenu.bMenu(bookControllerTest);
                    break;
           /*     case 2:
                    borrowDao.showBorrowHist();
                    break;*/
                case 3:
                    UsermanagerMenu usermanagerMenu = new UsermanagerMenu();
                    usermanagerMenu.usmm(adminController);
                    break;
                case 0:
                    keeploop = false;
                    break;
                default:
                    break;
            }
        }
    }
}
