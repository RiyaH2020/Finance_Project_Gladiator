package com.casestudy.dto;

import com.casestudy.entity.Product;

public class ProductEmiStatus {
	private Product product;
	private boolean isEmiPending;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public boolean isEmiPending() {
		return isEmiPending;
	}
	public void setEmiPending(boolean isEmiPending) {
		this.isEmiPending = isEmiPending;
	}

}
