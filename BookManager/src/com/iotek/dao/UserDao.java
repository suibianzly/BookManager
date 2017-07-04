package com.iotek.dao;

import java.util.List;

import com.iotek.entity.User;

public interface UserDao {
	public User getUserByNameAndPass(String name, String pass);
	public void addUser(User user);
}
