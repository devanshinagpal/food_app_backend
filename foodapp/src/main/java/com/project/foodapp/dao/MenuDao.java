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
		// TODO Auto-generated method stub
		return menuRepository.save(menu);
	}
	public List<Menu> getMenu() {
		// TODO Auto-generated method stub
		return menuRepository.findAll();
	}
	public void deleteMenu(int id) {
		// TODO Auto-generated method stub
		menuRepository.deleteById(id);
	}
	public Menu getMenuById(int menu_id) {
		// TODO Auto-generated method stub
		return menuRepository.getById(menu_id);
	}

}
