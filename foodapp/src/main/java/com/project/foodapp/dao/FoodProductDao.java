package com.project.foodapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.foodapp.dto.FoodProduct;
import com.project.foodapp.repository.FoodProductRepository;

@Repository
public class FoodProductDao {

	@Autowired
	FoodProductRepository repository;
	
	public FoodProduct addProduct(FoodProduct product) {
		return repository.save(product);
	}
	
	public void deleteProduct(int id) {
		  repository.deleteById(id);
	}

	public List<FoodProduct> getProduct() {
		return repository.findAll();
	}

	public FoodProduct updateProduct(FoodProduct product) {
		return repository.save(product);
	}

}
