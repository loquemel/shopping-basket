package com.shopping.basket.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.basket.dao.ItemRepository;
import com.shopping.basket.domain.Item;
import com.shopping.basket.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public List<Item> getItems() {
		return itemRepository.findAll();
	}
}
