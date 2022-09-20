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

import com.project.foodapp.dto.FoodProduct;
import com.project.foodapp.dto.Menu;
import com.project.foodapp.dto.User;
import com.project.foodapp.service.FoodProductService;
import com.project.foodapp.service.MenuService;
import com.project.foodapp.service.UserService;

@RestController

public class ProductController {

	@Autowired
	FoodProductService service;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/addproduct/{user_id}")
	public FoodProduct addProduct(@RequestBody FoodProduct product ,@PathVariable int user_id) {
		User user = userService.getUserById(user_id);
		Menu menu=user.getMenu();
		product.setMenu(menu);
		return service.addProduct(product);
	}
	
	@DeleteMapping("/deleteproduct/{id}")
	public void deleteProduct(@PathVariable("id") int id) {
		 service.deleteProduct(id);
	}
	
	@GetMapping("/getproduct")
	public List<FoodProduct> getProduct() {
		return service.getProduct();
	}
	
	@PutMapping("/updateproduct")
	public FoodProduct updateProduct(@RequestBody FoodProduct product) {
		return service.updateProduct(product);
	}
}

