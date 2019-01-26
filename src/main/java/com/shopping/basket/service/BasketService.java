package com.shopping.basket.service;

import java.util.List;

import com.shopping.basket.domain.Basket;
import com.shopping.basket.domain.CustomerBasketDTO;
import com.shopping.basket.domain.Item;

public interface BasketService {
	CustomerBasketDTO getBasketsByCustomerId(Long id);
	Basket createBasket(Long id);
	Basket getBasket(Long id);
	Basket addItem(Long id, List<Item> items);
}
