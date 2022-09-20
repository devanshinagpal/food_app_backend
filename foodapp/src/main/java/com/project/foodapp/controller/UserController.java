package com.project.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.foodapp.dto.Menu;
import com.project.foodapp.dto.User;
import com.project.foodapp.service.UserService;
@RestController

public class UserController {

	@Autowired
	UserService service;
	
	@Autowired
	MenuController controller;

	@PostMapping("/loginuser")
	public User userLogin(@RequestBody User user){
		return service.userLogin(user);
	}
	@PostMapping("/adduser")
	public User addUser(@RequestBody User user) {
		user=service.addUser(user);
		Menu menu=new Menu();
		controller.addMenu(menu, user.getId());
		return user;
	}

	@DeleteMapping("/deleteuser/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		service.deleteUser(id);
		return "Deleted User with Id : "+id;
	}

	@PutMapping("/updateuser/{id}")
	public User updateUser(@RequestBody User user,@PathVariable("id") int id) {
		return service.updateUser(user,id);
	}

	@GetMapping("/getuser/{id}")
	public User getUserById(@PathVariable("id") int id) {
		return service.getUserById(id);
	}
	@GetMapping("/getusers")
	public List<User> getUsers() {
		return service.getUsers();
	}

}
