package com.project.foodapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.foodapp.dto.User;
import com.project.foodapp.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	UserRepository repository;
	public User addUser(User user) {
		
		return repository.save(user);
	}
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		System.out.println("User Deleted with id :" +id);
	}
	
	public User updateUser(User updated_user, int id) {
		// TODO Auto-generated method stub
		User user=getUserById(id);
		user.setName(updated_user.getName());
		user.setPassword(updated_user.getPassword());
		user.setRole(updated_user.getRole());
		return repository.save(user);
	}
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public User getUserById(int id) {
		return repository.findById(id).get();
	}
	
	public User getByEmail(String email) {
		return repository.getByEmail(email);
	}
	public User userLogin(User user) {
		// TODO Auto-generated method stub
		User check=getByEmail(user.getEmail());
		if(check==null)
			return check;
		if(check.getPassword().equals(user.getPassword()))
			return check;
		return null;
	}
}
