package com.shopping.basket.domain;

import java.math.BigDecimal;
import java.util.List;

public class CustomerBasketDTO {

	private List<Basket> baskets;
	private BigDecimal totalPrice;

	public List<Basket> getBaskets() {
		return baskets;
	}

	public void setBaskets(List<Basket> baskets) {
		this.baskets = baskets;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
}
