package com.shopping.basket.service;

import java.util.List;

import com.shopping.basket.domain.Basket;
import com.shopping.basket.domain.Item;

public interface BasketService {

	Basket createBasket();
	Basket getBasket(Long id);
	Basket addItem(Long id, List<Item> items);
}
