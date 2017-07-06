package com.iotek.view;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import javax.security.auth.login.LoginContext;

import com.iotek.controller.UserController;
import com.iotek.entity.User;

public class MainMenu {
	UserController userController = new UserController();


	public void mai() throws Exception {
		Scanner scanner = new Scanner(System.in);
		boolean flat=true;
		while (flat) {
			System.out.println("1.登录");
			System.out.println("2.注册");
			System.out.println("0.退出");
			System.out.println("-------------");
			System.out.println("请选择：");
			int choose = 0;
			try {
				choose = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("请输入数字");
				mai();
			}
			switch (choose) {
				case 1:
					userController.login();
					break;
				case 2:
					userController.regist();
					break;
				case 0:
					System.exit(0);
					break;
				default:
					//mai();
					break;
			}
		}
	}
}