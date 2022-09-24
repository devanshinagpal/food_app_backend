package com.project.foodapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.foodapp.dto.FoodOrder;
import com.project.foodapp.repository.FoodOrderRepository;

@Repository
public class FoodOrderDao {
	@Autowired
	FoodOrderRepository repository;

	public FoodOrder addOrder(FoodOrder order) {
		order.setOrderCreatedTime(new java.util.Date() + "");
		return repository.save(order);
	}

	public FoodOrder updateOrder(FoodOrder order) {
		FoodOrder foodOrder = getOrderById(order.getId());
		foodOrder.setTotalPrice(order.getTotalPrice());
		foodOrder.setOrderDeliveryTime(new java.util.Date() + "");
		foodOrder.setStatus(true);
		return repository.save(foodOrder);
	}

	public FoodOrder getOrderById(int id) {
		return repository.findById(id).get();
	}

	public String deleteOrder(int id) {
		FoodOrder order = getOrderById(id);
		if (order != null) {
			repository.delete(order);
			return order.getCustomerName() + "the order is deleted";
		} else {
			return "No order is deleted";
		}
	}

	public FoodOrder getFoodOrderById(int foodorder_id) {
		FoodOrder order = getOrderById(foodorder_id);
		return order;
	}

}
