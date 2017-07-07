package com.iotek.view;

import com.iotek.constant.BookType;
import com.iotek.controller.BookControllerTest;
import com.iotek.entity.Book;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/7/3.
 */
public class ChangeMenu {
    Scanner sc = new Scanner(System.in);
    private Book book = new Book();

    private int bStock;
    private BookType bType;
    private String author;
    private double price;

    public void cMenu(BookControllerTest bookControllerTest) {
        System.out.println("请输入你要修改的书名");
        String bname = sc.next();

        book = bookControllerTest.find(bname);
        if (book == null) {return;
        } else {
           // bStock = book.getbStock();
            bType = book.getbType();
            author = book.getAuthor();
            price = book.getPrice();
            while (runmenu(bookControllerTest)) {
            }
           // book.setbStock(bStock);
            book.setbType(bType);
            book.setAuthor(author);
            book.setPrice(price);
            bookControllerTest.refreshBook(book);
        }
        return;
    }

    private boolean runmenu(BookControllerTest bookControllerTest) {
        System.out.println("请输入你要修改类型");
        System.out.println("1.作者");
      //  System.out.println("2.数量");
        System.out.println("2.价格");
        System.out.println("3.类型");
        System.out.println("0.退出");
        System.out.println("-------------");
        System.out.println("请选择：");
        int choose = 0;
        try {
            choose = sc.nextInt();
        } catch (Exception e) {
            System.out.println("请输入数字");
            return true;
        }
        switch (choose) {
            case 1:
                author = bookControllerTest.ReadAuthor();
                return true;
                     case 2:
                price = bookControllerTest.ReadPrice();
                return true;
            //  break;
            case 3:
                bType = bookControllerTest.ReadBtypes();
                return true;
            //  break;
            case 0:
                return false;//;
            default:
                return true;
            // break;
        }
    }
}
