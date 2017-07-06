package com.iotek.view;

import com.iotek.controller.BookControllerTest;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/6/30.
 */
public class BookMenu {

    Scanner sc = new Scanner(System.in);

    public void bMenu(BookControllerTest bookControllerTest) throws Exception {
        boolean falg = true;
        while (falg) {
            System.out.println("1 添加书籍信息");
            System.out.println("2 删除书籍信息");
            System.out.println("3 修改书籍信息");
            System.out.println("4 查看书籍信息");
            System.out.println("5 查找书籍");
            System.out.println("6 查看所有书籍信息");
            System.out.println("7 查看借书记录");

            System.out.println("0 返回上一层");
            sc = new Scanner(System.in);
            String key = sc.next();
            switch (key) {
                case "1":
                    bookControllerTest.add();
                    break;
                case "2":
                    bookControllerTest.del();
                    break;
                case "3":
                    ChangeMenu changeMenu = new ChangeMenu();
                    changeMenu.cMenu(bookControllerTest);
                    break;
                case "4":
                    bookControllerTest.showBookList();
                    break;
                case "5":
                    bookControllerTest.find();
                    break;
                case "6":
                    bookControllerTest.showAllBookInfo();
                    break;
                case "7":
                    bookControllerTest.showBorrowMessage();
                    break;
                case "0":
                    falg=false;
                    break;
                default:
                    break;

            }

        }
        return;

    }

}
