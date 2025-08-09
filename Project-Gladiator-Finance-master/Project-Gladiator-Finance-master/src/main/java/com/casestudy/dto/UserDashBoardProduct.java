package com.casestudy.dto;

import java.util.List;

import com.casestudy.entity.Order;
import com.casestudy.entity.Product;

public class UserDashBoardProduct {
	private List<Product> list;
	private ProductStatus status;
	private List<Order> orders;
	
	public static enum ProductStatus{
		PURCHASED,NO_HISTORY;
	}


	
	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}

	public ProductStatus getStatus() {
		return status;
	}

	public void setStatus(ProductStatus status) {
		this.status = status;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
