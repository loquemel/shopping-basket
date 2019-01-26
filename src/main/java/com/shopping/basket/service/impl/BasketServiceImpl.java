package com.shopping.basket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.basket.dao.BasketRepository;
import com.shopping.basket.domain.Basket;
import com.shopping.basket.domain.Item;
import com.shopping.basket.service.BasketService;

@Service
public class BasketServiceImpl implements BasketService {

	@Autowired
	private BasketRepository basketRepository;

	@Override
	public Basket createBasket() {
		Basket basket = new Basket();
		return basketRepository.save(basket);
	}

	@Override
	public Basket getBasket(Long id) {
		return basketRepository.findOneById(id);
	}

	@Override
	public Basket addItem(Long id, List<Item> items) {
		return null;
	}

}
