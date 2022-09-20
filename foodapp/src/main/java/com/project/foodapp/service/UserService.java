package com.project.foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.foodapp.dao.UserDao;
import com.project.foodapp.dto.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public User addUser(User user) {

		return userDao.addUser(user);
	}
	public User updateUser(User user, int id) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user,id);
	}

	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userDao.getUsers();
	}
	
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userDao.deleteUser(id);
	}
	
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}
	public User userLogin(User user) {
		return userDao.userLogin(user);
	}
}
