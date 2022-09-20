package com.project.foodapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.foodapp.dao.FoodOrderDao;
import com.project.foodapp.dto.FoodOrder;

@Service
public class FoodOrderService {

	@Autowired
	FoodOrderDao orderDao;

	public FoodOrder addOrder(FoodOrder order) {
		return orderDao.addOrder(order);
	}

	public FoodOrder updateOrder(FoodOrder order) {
		// TODO Auto-generated method stub
		return orderDao.updateOrder(order);
	}

	public FoodOrder getOrderById(int id) {
		// TODO Auto-generated method stub
		return orderDao.getOrderById(id);
	}

	public String deleteOrder(int id) {
		// TODO Auto-generated method stub
		return orderDao.deleteOrder(id);
	}

	public FoodOrder getFoodOrderById(int foodorder_id) {
		// TODO Auto-generated method stub
		return orderDao.getFoodOrderById(foodorder_id);
	}


}
