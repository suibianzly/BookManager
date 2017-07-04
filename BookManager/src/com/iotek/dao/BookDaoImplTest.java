package com.iotek.dao;

import com.iotek.entity.Book;
import com.iotek.until.IoUntils;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Administrator on 2017/6/30.
 */
public class BookDaoImplTest implements BookDao {
    private static String path = "book.text";
    private HashMap<String, Book> booksMap = new HashMap<String, Book>();
    FileInputStream fis = null;
    ObjectInputStream ois = null;
    FileOutputStream fos = null;
    ObjectOutputStream oos = null;

    public BookDaoImplTest() {
        try {
            booksMap = (HashMap<String, Book>) IoUntils.load(path, fis, ois).readObject();
            IoUntils.closeAll(fis, ois, fos, oos);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
        } catch (NullPointerException e) {

        }

    }

    @Override
    public void addBook(Book books) {
        addNewBook(books);
        saveBook();
        System.out.println("书本《" + books.getbName() + "》添加完成");
    }


    public void setBook(Book books) {
        booksMap.get(books.getbName()).setbStock(books.getbStock());
        booksMap.get(books.getbName()).setbType(books.getbType());
        booksMap.get(books.getbName()).setAuthor(books.getAuthor());
        booksMap.get(books.getbName()).setPrice(books.getPrice());

    }

    public void refreshBook(Book books) {
        if (booksMap.containsKey(books.getbName())) {
            setBook(books);
        } else {
            System.out.println("书本《" + books.getbName() + "》不存在");
            return;
        }

        saveBook();
        System.out.println("书本《" + books.getbName() + "》修改完成");
    }

    private void addNewBook(Book books) {
        if (booksMap.containsKey(books.getbName())) {
            booksMap.get(books.getbName()).addbStock(books.getbStock());
            booksMap.get(books.getbName()).setbType(books.getbType());
            booksMap.get(books.getbName()).setAuthor(books.getAuthor());
            booksMap.get(books.getbName()).setPrice(books.getPrice());
        } else {
            booksMap.put(books.getbName(), books);
        }

    }

    public void showBookList() {
        if (booksMap.size() == 0) {
            System.out.println("图书馆暂时没有书");
        } else {
            Iterator<String> booksname = booksMap.keySet().iterator();

            while (booksname.hasNext()) {
                showOneBook(booksMap.get(booksname.next()));

            }
        }
    }

    public void showOneBook(Book book) {
        System.out.print("书名:" + book.getbName());
        System.out.print(" 作者:" + book.getAuthor());
        System.out.print(" 数量:" + book.getbStock());
        System.out.print(" 价格:" + book.getPrice());
        System.out.print(" 类型:" + book.getbType());
        System.out.print(" 借出次数:" + book.getbNumber());
        System.out.println(" 书的ID:" + book.getbId());

    }

    public void delBook(String dname) {
        if (booksMap.containsKey(dname)) {
            booksMap.remove(dname);
            saveBook();

        } else {
            System.out.println("书本《" + dname + "》不存在");
        }
    }


    public Book findBook(String bookname) {
        if (booksMap.containsKey(bookname)) {

            showOneBook(booksMap.get(bookname));
            return booksMap.get(bookname);
        } else {

            System.out.println("找不到该书");
            return null;
        }


    }

    public void borrow(String bookname, int borrownum) {
        booksMap.get(bookname).borrowStock(borrownum);
        saveBook();
    }

    public void saveBook() {
        try {
            IoUntils.save(path, fos, oos).writeObject(booksMap);
            IoUntils.closeAll(fis, ois, fos, oos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void returnBook(String bookname, int returnwnum) {
        booksMap.get(bookname).addbStock(returnwnum);
        saveBook();
    }
}
