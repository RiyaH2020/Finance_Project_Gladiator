package com.casestudy.service;
import com.casestudy.entity.Order;

public interface OrderService {
	
	public Order orderProduct(String username,int scheme,int prod_id);
	public void checkCardAmount(String username,int prod_id);

}
