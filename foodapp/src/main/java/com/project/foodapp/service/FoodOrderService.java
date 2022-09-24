package com.project.foodapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.foodapp.dao.FoodOrderDao;
import com.project.foodapp.dto.FoodOrder;
import com.project.foodapp.exception.IdNotFoundException;
import com.project.foodapp.response.ResponseStructure;

@Service
public class FoodOrderService {

	@Autowired
	FoodOrderDao orderDao;

	public FoodOrder addOrder(FoodOrder order) {
		return orderDao.addOrder(order);
	}

	public FoodOrder updateOrder(FoodOrder order) {
		return orderDao.updateOrder(order);
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> getOrderById(int id) { 
		FoodOrder optional=orderDao.getOrderById(id);
		if(optional==null) { 
			throw new IdNotFoundException("No such Id "+id+"is present");
		} 
		else {
			ResponseStructure<FoodOrder> responseStructure=new ResponseStructure<FoodOrder>(); 
			responseStructure.setMessage("Success");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(null);
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.OK);
		} 
		} 

	public String deleteOrder(int id) {
		return orderDao.deleteOrder(id);
	}

	public FoodOrder getFoodOrderById(int foodorder_id) {
		return orderDao.getFoodOrderById(foodorder_id);
	}


}
