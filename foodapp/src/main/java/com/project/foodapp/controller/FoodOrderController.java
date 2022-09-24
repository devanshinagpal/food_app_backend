package com.project.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.foodapp.dto.FoodOrder;
import com.project.foodapp.dto.Menu;
import com.project.foodapp.dto.User;
import com.project.foodapp.service.FoodOrderService;
import com.project.foodapp.service.MenuService;
import com.project.foodapp.service.UserService;

@RestController
@CrossOrigin
public class FoodOrderController {
    @Autowired
	FoodOrderService service;
	
    @Autowired
    UserService userService;
    
	@PostMapping("/addOrder/{user_id}")
	public FoodOrder addOrder(@RequestBody FoodOrder order,@PathVariable int user_id) {
		User user = userService.getUserById(user_id);
		order.setUser(user);
		return service.addOrder(order);
	}
	
	@PutMapping("/updateorder")
	public FoodOrder updateOrder(@RequestBody FoodOrder order) {
		return service.updateOrder(order);
	}
	
	@GetMapping("/order/{user_id}")
	public List<FoodOrder> getOrderById(@PathVariable("user_id") int id) {
		User user=userService.getUserById(id);
		return user.getFoodOrders();
	}
	
	@DeleteMapping("/delete/order/{user_id}")
	public String deleteOrder(@PathVariable("user_id") int user_id) {
		return service.deleteOrder(user_id);
	}
	
	@GetMapping("getorderbyid/{order_id}")
	public FoodOrder getOrderByOrderId(@PathVariable("order_id") int order_id) {
		System.out.println("");
		return service.getFoodOrderById(order_id);
		
	}
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=Exception.class)
	public String exceptionGenericlass() {
		return "null_page";
	}
}
