package com.shopping.basket.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.basket.dao.BasketRepository;
import com.shopping.basket.dao.CustomerRepository;
import com.shopping.basket.dao.ItemRepository;
import com.shopping.basket.domain.Basket;
import com.shopping.basket.domain.Customer;
import com.shopping.basket.domain.CustomerBasketDTO;
import com.shopping.basket.domain.Item;
import com.shopping.basket.service.BasketService;

@Service
public class BasketServiceImpl implements BasketService {

	@Autowired
	private BasketRepository basketRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private CustomerRepository customerRepository;

	public static final Logger logger = LoggerFactory.getLogger(BasketServiceImpl.class);

	@Override
	public CustomerBasketDTO getBasketsByCustomerId(Long id) {		
		BigDecimal totalPrice = BigDecimal.ZERO;
		List<Basket> baskets = basketRepository.findAllByCustomerId(id);

		for (Basket basket : baskets) {
			Set<Item> items = basket.getItems();
			for (Item item : items) {
				totalPrice = totalPrice.add(item.getPrice());
			}
		}
		CustomerBasketDTO customerBaskets = new CustomerBasketDTO();
		customerBaskets.setBaskets(baskets);
		customerBaskets.setTotalPrice(totalPrice);

		return customerBaskets;
	}

	@Override
	public Basket createBasket(Long id) {
		Basket basket = new Basket();
		Customer customer = customerRepository.findOneById(id);
		basket.setCustomerId(customer.getId());
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
