package com.project.foodapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.foodapp.dto.Item;
import com.project.foodapp.repository.ItemRepository;

@Repository
public class ItemDao {

	@Autowired
	ItemRepository itemRepository;
	public List<Item> getItems() {
		// TODO Auto-generated method stub
		return itemRepository.findAll();
	}
	public Item updateItem(Item item) {
		// TODO Auto-generated method stub
		return itemRepository.save(item);
	}
	public void deleteItem(int id) {
		// TODO Auto-generated method stub
		itemRepository.deleteById(id);
	}
	public Item addItem(Item item) {
		// TODO Auto-generated method stub
		return itemRepository.save(item);
	}
	
}
