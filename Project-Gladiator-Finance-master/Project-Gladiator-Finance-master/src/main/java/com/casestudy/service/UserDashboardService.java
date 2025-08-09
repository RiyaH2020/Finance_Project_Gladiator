package com.casestudy.service;

import java.util.List;

import com.casestudy.entity.Card;
import com.casestudy.entity.Installment;
import com.casestudy.entity.Order;
import com.casestudy.entity.Product;

public interface UserDashboardService {
	
	public Card viewCardDetails(String username);
	public List<Product> viewPurchasedProducts(Card card);
	public List<Installment> viewRecentTransactions(Card card);
	public List<Order> viewOrders(Card card);
	public void updateCard(String username,String cardType);

}
