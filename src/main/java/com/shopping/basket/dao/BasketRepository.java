package com.shopping.basket.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shopping.basket.domain.Basket;

@Repository
public interface BasketRepository extends CrudRepository<Basket, Long> {
	List<Basket> findAllByCustomerId(Long id);
	Basket findOneById(Long id);
}
