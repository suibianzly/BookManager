package com.iotek.dao;

import java.io.*;
import java.util.ArrayList;

import com.iotek.entity.User;
import com.iotek.until.IoUntils;


public class UserDaoImpl implements UserDao {
    private static String path = "users.text";
    private ArrayList<User> users = new ArrayList<User>();
    FileInputStream fis = null;
    ObjectInputStream ois = null;
    FileOutputStream fos = null;
    ObjectOutputStream oos = null;

    public ArrayList<User> getUsers() {
        return users;
    }

    public UserDaoImpl() {
        try {
            //将数据读取出来保存在内存中
            users = (ArrayList<User>) IoUntils.load(path, fis, ois).readObject();
            IoUntils.closeAll(fis, ois, fos, oos);

        } catch (Exception e) {
        /*	e.printStackTrace();*/
        }
        ;
    }

    @Override
    public User getUserByNameAndPass(String name, String pass) {
        ArrayList<User> us = new ArrayList<User>();
        us.addAll(users);
        us.add(new User(1000, "adm", "adm", "男", 22, 1, 1000));
        if (us.size() != 0) {
            for (User u : us) {
                if (u.getuName().equals(name) && u.getuPass().equals(pass)) {
                    return u;
                }
            }
        }
        return null;
    }

    public User getUserByNames(String name) {
        if (users.size() != 0) {
            for (User u : users) {
                if (u.getuName().equals(name)) {
                    return u;
                }
            }
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
        try {
            //将数据写入文件中。
            IoUntils.save(path, fos, oos).writeObject(users);
            IoUntils.closeAll(fis, ois, fos, oos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int getMaxId() {
        int maxid = 0;
        if (users.size() > 0) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i) != null && maxid < users.get(i).getuId()) {
                    maxid = users.get(i).getuId();
                }
            }

        }
        return maxid;
    }
}
