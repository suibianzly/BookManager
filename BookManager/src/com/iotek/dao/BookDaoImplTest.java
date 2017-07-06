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
    //   public int max_id=getMaxId();

    public BookDaoImplTest() {
        try {
            booksMap = (HashMap<String, Book>) IoUntils.load(path, fis, ois).readObject();
            IoUntils.closeAll(fis, ois, fos, oos);
        } catch (Exception e) {
        }
        }
            //e.printStackTrace();
      //  } catch (ClassNotFoundException e) {
     //   } catch (NullPointerException e) {

       // }



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
        if (book == null) {
            return;
        } else {
            System.out.println(book);
        }

    }

    public void delBook(String dname) {
        if (booksMap.containsKey(dname)) {
            booksMap.remove(dname);
            saveBook();
            System.out.println("书本《" + dname + "》删除成功");
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
        booksMap.get(bookname).returnStock(returnwnum);
        saveBook();
    }


    public int getMaxId() {
        int maxid = 0;
        Iterator bookit = booksMap.keySet().iterator();
        while (bookit.hasNext()) {

            Book book = booksMap.get(bookit.next());
            if (maxid < book.getbId()) {
                maxid = book.getbId();
            }


        }
        return maxid;
    }
}
