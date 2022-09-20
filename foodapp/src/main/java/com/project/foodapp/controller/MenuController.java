package com.project.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.foodapp.dto.Menu;
import com.project.foodapp.dto.User;
import com.project.foodapp.service.MenuService;
import com.project.foodapp.service.UserService;

@RestController
public class MenuController {

	@Autowired
	MenuService service;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/addmenu/{user_id}")
	public Menu addMenu(@RequestBody Menu menu,@PathVariable int user_id) {
		User user=userService.getUserById(user_id);
		menu.setUser(user);
		return service.addMenu(menu);
		
	}
	
	@GetMapping("/getmenus")
	public List<Menu> getMenu() {
		return service.getMenu();
	}
	
	@GetMapping("/getmenu/{user_id}")
	public Menu getMenuByUserId(@PathVariable int user_id) {
    return userService.getUserById(user_id).getMenu();
	}
	
	@DeleteMapping("/deletemenu/{id}")
	public void deleteMenu(
			@PathVariable int id){
		service.deleteMenu(id);
	}
}
