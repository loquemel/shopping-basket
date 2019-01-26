package com.shopping.basket.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.basket.dao.BasketRepository;
import com.shopping.basket.dao.ItemRepository;
import com.shopping.basket.domain.Basket;
import com.shopping.basket.domain.Item;
import com.shopping.basket.service.BasketService;

@Service
public class BasketServiceImpl implements BasketService {

	@Autowired
	private BasketRepository basketRepository;

	@Autowired
	private ItemRepository itemRepository;

	public static final Logger logger = LoggerFactory.getLogger(BasketServiceImpl.class);

	@Override
	public List<Basket> getBaskets() {
		return basketRepository.findAll();
	}

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
		Basket basket = basketRepository.findOneById(id);
		for (Item item : items) {
			Item savedItem = itemRepository.findOneById(item.getId());
			savedItem.setBasketId(basket.getId());
			basket.addItem(savedItem);
		}
		return basketRepository.save(basket);
	}

}
