package com.iotek.controller;

import com.iotek.constant.BookType;
import com.iotek.dao.BookDaoImplTest;
import com.iotek.dao.BookInfoDaoImpl;
import com.iotek.entity.Book;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/6/30.
 */
public class BookControllerTest {
    BookDaoImplTest bookDaoImpl = new BookDaoImplTest();
    Scanner sc = new Scanner(System.in);
    public BookInfoDaoImpl bookInfoDao = new BookInfoDaoImpl();

    // public Book book=new Book();
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

    //键盘输入类型
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
    //J键盘输入价格
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
            if(price<0){
                System.out.println("价格不能是负数");
                System.out.println("请重新输入");
            }
        }
        return price;
    }
    //键盘输入数量
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
    // 从键盘输入书名
    public String ReadBookName() {
        System.out.println("请输入书籍名称");
        String bName = sc.next();
        return bName;
    }
    //从键盘输入作者
    public String ReadAuthor() {
        System.out.println("请输入书籍作者");
        String author = sc.next();
        return author;
    }
    //通过书籍名字取ID
    public int getBookIdWithBookName(String bookname) {

        return bookDaoImpl.getBookIdWithBookName(bookname);
    }
    //遍历书籍类型
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
            while (true) {
                System.out.println("请确认书籍是否完整：损坏/丢失/完整");
                String judge = sc.next();

                if (judge.equals("损坏")) {
                    int returnwnum = ReadbStock();
                    userController.user.setUpoint(userController.user.getUpoint() - 10 * returnwnum);

                    userController.userDaoImpl.changeUser(userController.user);
                    bookDaoImpl.returnBook(bookname, returnwnum);
                    bookInfoDao.returnBook(book.getbId(), returnwnum, userController, false, true, false);
                    break;
                } else if (judge.equals("丢失")) {
                    int returnwnum = ReadbStock();
                    userController.user.setUpoint(userController.user.getUpoint() - 50 * returnwnum);
                    userController.userDaoImpl.changeUser(userController.user);
                    //   bookDaoImpl.returnBook(bookname, 0);
                    bookInfoDao.returnBook(book.getbId(), returnwnum, userController, true, false, true);
                    break;
                } else if (judge.equals("完整")) {
                    int returnwnum = ReadbStock();
                    bookDaoImpl.returnBook(bookname, returnwnum);
                    bookInfoDao.returnBook(book.getbId(), returnwnum, userController, false, false, false);
                    break;
                } else {
                    System.out.println("输入错误");
                }
            }
            System.out.println("还书成功");

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
