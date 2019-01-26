package com.shopping.basket.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shopping.basket.domain.Item;

public interface ItemRepository extends CrudRepository<Item, Long>{

	Item findOneById(Long id);
	List<Item> findAll();
}
