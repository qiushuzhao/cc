package com.dao;

import java.util.List;

import com.model.User;

public interface UserDao {
	public List<User> getUsersByName(String name);

	public List<User> getAllUser();

	public void insertUser(User user);

	public void deleteUserById(int id);

	public void updateUserById(User user);

	public User getUserById(int id);
}