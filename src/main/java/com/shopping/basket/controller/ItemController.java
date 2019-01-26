package com.shopping.basket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.shopping.basket.domain.Item;
import com.shopping.basket.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping("/items")
	public ResponseEntity<List<Item>> getItems() {
		List<Item> items = itemService.getItems();
		return new ResponseEntity<>(items, HttpStatus.OK);
	}
}
