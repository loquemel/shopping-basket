package com.shopping.basket.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shopping.basket.domain.Basket;

@Repository
public interface BasketRepository extends CrudRepository<Basket, Long> {

	Basket findOneById(Long id);
}
