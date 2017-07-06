package com.iotek.controller;


import com.iotek.dao.UserDaoImpl;
import com.iotek.entity.User;
import com.iotek.view.ManagerMenu;
import com.iotek.view.UserMenu;

import java.util.Scanner;

public class UserController {
    UserDaoImpl userDaoImpl = new UserDaoImpl();
    Scanner scanner = new Scanner(System.in);
    public User user = new User();
    BookControllerTest bookControllerTest = new BookControllerTest();

    /*登录*/
    public void login() throws Exception {
        while (true) {
            System.out.println("请输入用户名");
            String name = scanner.next();
            System.out.println("请输入密码");
            String pass = scanner.next();
            user = userDaoImpl.getUserByNameAndPass(name, pass);
            if (user == null) {
                System.out.println("用户名不存在");
                System.out.println("是否继续:Y/N");
                String ReturnYN = scanner.next();
                if (ReturnYN.equals("Y")) {
                } else {
                    break;
                }
            } else {
                if (user.getuLevel() == 1) {
                    System.out.println("你是管理员");
                    ManagerMenu managerMenu = new ManagerMenu();
                    managerMenu.managerMenu(bookControllerTest);
                } else {
                    System.out.println("你是普通用户");
                    UserMenu userMenu = new UserMenu();
                    userMenu.usMenu(this);
                }
                break;

            }

        }
    }



    public void regist() throws Exception {
        System.out.println("请输入用户名");
        String name = scanner.next();
        User checkuser = userDaoImpl.getUserByNames(name);
        if (checkuser != null) {
            System.out.println("用户名已存在");
            System.out.println("是否继续:Y/N");
            String ReturnYN = scanner.next();
            if (ReturnYN.equals("Y")) {
                regist();
                System.exit(0);
            } else {
                System.exit(0);
            }
        }
        System.out.println("请输入用性别:男/女");
        String sex = scanner.next();
        if (!sex.equals("男") && !sex.equals("女")) {
            System.out.println("性别错误，请输入:男/女");
            System.out.println("请重新输入注册信息");

            regist();
            System.exit(0);
        }
        System.out.println("请输入用年龄");
        int age = 0;
        try {
            age = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("年龄不是数字");
            System.out.println("请重新输入注册信息");

            regist();
            System.exit(0);
        }
        System.out.println("请输入密码");
        String pass = scanner.next();
        System.out.println("重复输入密码");
        String pass2 = scanner.next();
        if (!pass.equals(pass2)) {
            System.out.println("密码不一致");
            System.out.println("请重新输入注册信息");
            regist();
            System.exit(0);
        }
        User user = new User();
        user.setuName(name);
        user.setuPass(pass);
        user.setuLevel(0);
        user.setuAge(age);
        user.setuSex(sex);
        int MaxId = userDaoImpl.getMaxId();
        int Id = MaxId + 1;
        user.setuId(Id);
        userDaoImpl.addUser(user);
        System.out.println("是否继续登录:Y/N");
        String loginYn = scanner.next();
        if (loginYn.equals("Y")) {
            login();
        } else {
            System.exit(0);
        }

    }


    public void checkPersonalInfo() {
        System.out.println(user);
    }

    public void checkBookinfo() {
        bookControllerTest.showBookList();
    }

    public void Borrow() throws Exception {
        bookControllerTest.Borrow(this);

    }

    public void returnBook() throws Exception {
        bookControllerTest.returnBook(this);
    }

    public void borrow(int borrownum) {
        userDaoImpl.borrow(user, borrownum);
    }
    public void reservtion(){
        System.out.println("请输入需要预约的书籍名称");

    }
}
