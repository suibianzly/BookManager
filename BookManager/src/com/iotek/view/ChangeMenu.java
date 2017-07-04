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
        System.out.println("��������Ҫ�޸ĵ�����");
        String bname = sc.next();
        book = bookControllerTest.find(bname);
        bStock = book.getbStock();
        bType = book.getbType();
        author = book.getAuthor();
        price = book.getPrice();
        while (runmenu(bookControllerTest)) {

        }
        book.setbStock(bStock);
        book.setbType(bType);
        book.setAuthor(author);
        book.setPrice(price);
        bookControllerTest.refreshBook(book);
    }

    private boolean runmenu(BookControllerTest bookControllerTest) {
        System.out.println("��������Ҫ�޸�����");
        System.out.println("1.����");
        System.out.println("2.����");
        System.out.println("3.�۸�");
        System.out.println("4.����");
        System.out.println("5.�˳�");
        System.out.println("-------------");
        System.out.println("��ѡ��");
        int choose = 0;
        try {
            choose = sc.nextInt();
        } catch (Exception e) {
            System.out.println("����������");
            cMenu(bookControllerTest);
        }
        switch (choose) {
            case 1:
                author = bookControllerTest.SetAuthor();
                return true;
            //break;
            case 2:
                bStock = bookControllerTest.SetbStock();
                return true;
            //    break;
            case 3:
                price = bookControllerTest.Setprice();
                return true;
            //  break;
            case 4:
                bType = bookControllerTest.SetBtypes();
                return true;
            //  break;
            case 5:
                return false;//;
            default:
                return true;
            // break;
        }
    }
}
