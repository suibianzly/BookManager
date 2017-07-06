package com.iotek.controller;

import com.iotek.constant.BookType;
import com.iotek.dao.BookDaoImplTest;
import com.iotek.dao.BookInfoDao;
import com.iotek.dao.BookInfoDaoImpl;
import com.iotek.dao.BorrowDaoImpl;
import com.iotek.entity.Book;
import com.iotek.entity.BookInfo;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/6/30.
 */
public class BookControllerTest {
    BookDaoImplTest bookDaoImpl = new BookDaoImplTest();
    Scanner sc = new Scanner(System.in);
    BookInfoDaoImpl bookInfoDao = new BookInfoDaoImpl();
    public Book book=new Book();
    public void add() throws Exception {
        String bName = ReadBookName();
        String author = ReadAuthor();
        int bStock = ReadbStock();
        double price = ReadPrice();
        BookType Btypes = ReadBtypes();
        Book book = new Book();
        book.setbName(bName);
        book.setbStock(bStock);
        book.setbType(Btypes);
        book.setAuthor(author);
        book.setPrice(price);
        book.setbId(bookDaoImpl.getMaxId() + 1);
        bookDaoImpl.addBook(book);
        bookInfoDao.addBook(book);
    }

    public void showAllBookInfo() {
        bookInfoDao.showAllBookInfo();
    }

    public void refreshBook(Book book) {
        bookDaoImpl.refreshBook(book);
    }


    public BookType ReadBtypes() {
        System.out.println("请输入书籍类型:");
        PrintBookType();
        String Btype;
        BookType Btypes;
        while (true) {
            Btype = sc.next();
            Btypes = StringToBookType(Btype);
            if (Btypes == null) {
                System.out.println("书籍类型不满足");
                System.out.println("请重新输入书籍类型");
            } else {
                break;
            }
        }
        return Btypes;
    }

    public double ReadPrice() {
        System.out.println("请输入书籍价格");
        double price = 0;
        boolean flag = true;
        while (flag) {

            try {
                sc = new Scanner(System.in);
                flag = true;
                price = sc.nextDouble();
                flag = false;
            } catch (Exception e) {
                System.out.println("价格不是数字");
                System.out.println("请重新输入");

            }
        }
        return price;
    }

    public int ReadbStock() {
        System.out.println("请输入书籍数量");
        int bStock = 0;
        boolean flag = true;
        while (flag) {
            try {
                sc = new Scanner(System.in);
                bStock = sc.nextInt();
                flag = false;
            } catch (Exception e) {
                System.out.println("数量不是数字");
                System.out.println("请重新输入");
            }
        }
        return bStock;
    }

    public String ReadBookName() {
        System.out.println("请输入书籍名称");
        String bName = sc.next();
        return bName;
    }

    public String ReadAuthor() {
        System.out.println("请输入书籍作者");
        String author = sc.next();
        return author;
    }

    private void PrintBookType() {
        System.out.print(BookType.教育.type);
        System.out.print(" " + BookType.小说.type);
        System.out.print(" " + BookType.文艺.type);
        System.out.print(" " + BookType.童书.type);
        System.out.print(" " + BookType.生活.type);
        System.out.print(" " + BookType.人文社科.type);
        System.out.print(" " + BookType.经管.type);
        System.out.println(" " + BookType.科技.type);
    }

    private BookType StringToBookType(String btype) {
        BookType bt;
        switch (btype) {
            case "教育":
                bt = BookType.教育;
                break;
            case "小说":
                bt = BookType.小说;
                break;
            case "文艺":
                bt = BookType.文艺;
                break;
            case "童书":
                bt = BookType.童书;
                break;
            case "生活":
                bt = BookType.生活;
                break;
            case "人文社科":
                bt = BookType.人文社科;
                break;
            case "经管":
                bt = BookType.经管;
                break;
            case "科技":
                bt = BookType.科技;
                break;
            default:
                bt = null;
                break;
        }
        return bt;
    }

    public void showBookList() {
        bookDaoImpl.showBookList();

    }

    public void del() {
        System.out.println("请输入要删除的书名信息");
        String Dname = ReadBookName();
        Book book = bookDaoImpl.findBook(Dname);

        bookDaoImpl.delBook(Dname);
        if (book == null) {
            return;
        } else {
            bookInfoDao.delBook(book.getbId());
        }

    }


    public Book find(String bookname) {
        return bookDaoImpl.findBook(bookname);
    }


    public void Borrow(UserController userController) throws Exception {
        String bookname = ReadBookName();
        Book book = find(bookname);

        if (book != null) {
            int bookcount = book.getbStock();
            int borrownum = ReadbStock();

            while (true) {
                if (borrownum > bookcount) {
                    System.out.println("借的数量过大");
                } else {
                    bookDaoImpl.borrow(bookname, borrownum);
                    bookInfoDao.borrow(book.getbId(), borrownum, userController);
                    userController.borrow(borrownum);
                    break;
                }
            }

        }
    }

    /*还书*/
    public void returnBook(UserController userController) throws Exception {
        String bookname = ReadBookName();

        Book book = find(bookname);

        if (book != null) {
            System.out.println("请确认书籍是否完整：损坏/丢失/完整");
            String judge = sc.next();
            if (judge.equals("损坏")) {
                userController.user.setUpoint(userController.user.getUpoint() - 10);

            } else if (judge.equals("丢失")) {
                System.out.println("此账户冻结");

            } else if (judge.equals("完整")) {
                int returnwnum = ReadbStock();
                bookDaoImpl.returnBook(bookname, returnwnum);
                bookInfoDao.returnBook(book.getbId(), returnwnum, userController);

            }

        }
    }

    public void find() {
        System.out.println("请输入你要找的书名");
        String bookname = sc.next();
        Book book = find(bookname);
        if (book != null) {
            bookInfoDao.showFindedBookInfos(book.getbId());
        }
    }

    public void showBorrowMessage() {
        bookInfoDao.showBorrowMessage();
    }
}
