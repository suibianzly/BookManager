package com.iotek.controller;

import com.iotek.constant.BookType;
import com.iotek.dao.BookDaoImplTest;
import com.iotek.entity.Book;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/6/30.
 */
public class BookControllerTest {
    BookDaoImplTest bookDaoImpl = new BookDaoImplTest();
    Scanner sc = new Scanner(System.in);

    public void ContinueChoose(Method method) {
        System.out.println("是否继续:Y/N");
        sc = new Scanner(System.in);
        String yn = sc.next();
        if (yn.equals("Y")) {
            try {
                method.invoke(this);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return;
        } else {
            return;
        }
    }


    public void add() throws Exception {
        String bName = SetBookName();
        String author = SetAuthor();
        int bStock = SetbStock();
        double price = Setprice();
        BookType Btypes = SetBtypes();
        Book book = new Book();
        book.setbName(bName);
        book.setbStock(bStock);
        book.setbType(Btypes);
        book.setAuthor(author);
        book.setPrice(price);
        bookDaoImpl.addBook(book);

    }

    public void refreshBook(Book book){
        bookDaoImpl.refreshBook(book);
    }


    public BookType SetBtypes() {
        System.out.println("请输入书籍类型:");
        PrintBookType();
        String Btype = sc.next();
        BookType Btypes;
        while (true) {
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

    public double Setprice() {
        System.out.println("请输入书籍价格");
        double price = 0;
        boolean flag = false;
        while (true) {
            if (flag) {
                break;
            }
            try {
                sc = new Scanner(System.in);
                flag = true;
                price = sc.nextDouble();
            } catch (Exception e) {
                System.out.println("价格不是数字");
                System.out.println("请重新输入");
                flag = false;
            }
        }
        return price;
    }

    public int SetbStock() {
        System.out.println("请输入书籍数量");
        int bStock = 0;
        boolean flag = false;
        while (true) {
            if (flag) {
                break;
            }
            try {
                sc = new Scanner(System.in);
                flag = true;
                bStock = sc.nextInt();
            } catch (Exception e) {
                System.out.println("数量不是数字");
                System.out.println("请重新输入");
                flag = false;
            }
        }
        return bStock;
    }

    public String SetBookName() {
        System.out.println("请输入书籍名称");
        String bName = sc.next();
        return bName;
    }

    public String SetAuthor() {
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
        System.out.print(" " + BookType.科技.type);
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
        System.out.println("请输入要删除的书名");
        String Dname = sc.next();
        bookDaoImpl.delBook(Dname);
        System.out.println("书本《" + Dname + "》删除成功");

    }


    public Book find(String bookname) {
        return bookDaoImpl.findBook(bookname);
    }


    public void Borrow() throws Exception {
        System.out.println("请输入你要借的书名");
        String bookname = sc.next();
        int bookcount = 0;
        if (find(bookname) != null) {
            bookcount = find(bookname).getbStock();

            System.out.println("请输入你要的数量");
            int borrownum = 0;
            try {
                borrownum = sc.nextInt();
            } catch (Exception e) {
                System.out.println("数量必须是数字");
                ContinueChoose(this.getClass().getMethod("Borrow"));
                return;


            }
            if (borrownum > bookcount) {
                System.out.println("借的数量过大");
                ContinueChoose(this.getClass().getMethod("Borrow"));
                return;
            } else {
                bookDaoImpl.borrow(bookname, borrownum);

            }

        }
    }
    /*还书*/
    public void returnBook() throws Exception {
        System.out.println("请输入你要还的书名");
        String bookname = sc.next();
        System.out.println("请输入数量");
        int returnwnum = 0;
        try {
            returnwnum = sc.nextInt();
        } catch (Exception e) {
            System.out.println("数量必须是数字");
            ContinueChoose(this.getClass().getMethod("returnBook"));
            return;
        }
        bookDaoImpl.returnBook(bookname, returnwnum);

    }


    public void find() {
        System.out.println("请输入你要找的书名");
        String bookname = sc.next();
        bookDaoImpl.showOneBook(find(bookname));
    }
}
