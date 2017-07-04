package com.iotek.view;

import com.iotek.controller.BookControllerTest;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/6/30.
 */
public class BookMenu {
    // BookController bookController=new BookController();
    Scanner sc = new Scanner(System.in);

    public void bMenu(BookControllerTest bookControllerTest) throws Exception {
        boolean falg = true;
        while (true) {
            System.out.println("1 添加书籍信息");
            System.out.println("2 删除书籍信息");
            System.out.println("3 修改书籍信息");
            System.out.println("4 查看书籍信息");
            System.out.println("5 查找书籍");
            System.out.println("0  返回上一层");
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

                case "0":
                    falg=false;
                    break;
                default:
                    bMenu(bookControllerTest);

            }

        }

    }

}
