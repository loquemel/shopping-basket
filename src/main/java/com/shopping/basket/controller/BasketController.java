package com.shopping.basket.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.basket.domain.Basket;
import com.shopping.basket.domain.Item;
import com.shopping.basket.service.BasketService;

@RestController
public class BasketController {

	public static final Logger logger = LoggerFactory.getLogger(BasketController.class);

	@Autowired
	private BasketService basketService;

	@PostMapping("/basket")
	public ResponseEntity<Basket> createBasket() {
		logger.info("Creating basket..");

		Basket basket = basketService.createBasket();
		return new ResponseEntity<>(basket, HttpStatus.OK);
	}

	@GetMapping("/basket/{id}")
	public ResponseEntity<Basket> getBasket(@PathVariable Long id) {
		logger.info("Getting basket : " + id);
		Basket basket = basketService.getBasket(id);
		return new ResponseEntity<>(basket, HttpStatus.OK);
	}

	@PostMapping("/basket/{id}")
	public ResponseEntity<Basket> addItem(@PathVariable Long id, @RequestBody List<Item> items) {
		logger.info("Adding items to basket: " + id + " : " + items);
		Basket basket = basketService.addItem(id, items);
		return new ResponseEntity<>(basket, HttpStatus.OK);
	}
}
