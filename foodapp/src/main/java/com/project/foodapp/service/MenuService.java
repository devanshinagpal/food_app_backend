package com.project.foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.foodapp.dao.MenuDao;
import com.project.foodapp.dto.Menu;

@Service
public class MenuService {

	@Autowired
	MenuDao menuDao;
	
	public Menu addMenu(Menu menu) {
		// TODO Auto-generated method stub
		return menuDao.addMenu(menu);
	}


	public List<Menu> getMenu() {
		// TODO Auto-generated method stub
		
		return menuDao.getMenu();
	}


	public void deleteMenu(int id) {
		// TODO Auto-generated method stub
		menuDao.deleteMenu(id);
	}


	public Menu getMenuById(int menu_id) {
		// TODO Auto-generated method stub
		return menuDao.getMenuById(menu_id);
	}


}
