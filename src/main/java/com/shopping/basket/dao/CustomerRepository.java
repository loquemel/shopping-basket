package com.shopping.basket.dao;

import org.springframework.data.repository.CrudRepository;

import com.shopping.basket.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

	Customer findOneById(Long id);
}
