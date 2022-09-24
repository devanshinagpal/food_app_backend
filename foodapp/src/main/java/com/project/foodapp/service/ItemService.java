package com.project.foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.foodapp.dao.ItemDao;
import com.project.foodapp.dto.Item;

@Service
public class ItemService {

	@Autowired
	ItemDao itemDao;
	
	public List<Item> getItems() {	
		return itemDao.getItems();
	}

	public Item updateItem(Item item) {
		return itemDao.updateItem(item);
	}

	public void deleteItem(int id) {
		itemDao.deleteItem(id);
	}

	public Item addItem(Item item) {
		return itemDao.addItem(item);
	}
}
