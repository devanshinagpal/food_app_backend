package com.project.foodapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.foodapp.dto.Menu;
import com.project.foodapp.repository.MenuRepository;

@Repository
public class MenuDao {

	@Autowired
	MenuRepository menuRepository;
	
	public Menu addMenu(Menu menu) {
		return menuRepository.save(menu);
	}
	
	public List<Menu> getMenu() {
		return menuRepository.findAll();
	}
	
	public void deleteMenu(int id) {
		menuRepository.deleteById(id);
	}
	
	public Menu getMenuById(int menu_id) {
		return menuRepository.getById(menu_id);
	}

}
