package com.project.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.foodapp.dto.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
