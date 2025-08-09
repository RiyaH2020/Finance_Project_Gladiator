package com.casestudy.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.entity.Card;
import com.casestudy.entity.Installment;
import com.casestudy.entity.Order;
import com.casestudy.entity.Product;
import com.casestudy.exception.OrderException;
import com.casestudy.repository.OrderRepository;

@Service

public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository repo;

	@Transactional
	public Order orderProduct(String username, int scheme, int prod_id) {
		Card card=repo.fetchCardByUsername(username);
		Product product=repo.fetch(Product.class, prod_id);
		double amount=repo.fetchAmount(prod_id);
		List<Installment> list=new ArrayList<Installment>();
		Installment arr[]=new Installment[scheme];
		Order order=new Order();
		order.setAmount(amount);
		order.setEmiScheme(scheme);
		order.setPlacedDate(LocalDate.now());
		order.setStatus("Dispatched");
		order.setCard(card);
		order.setProduct(product);
		
		for(int i=0;i<scheme;i++) {
			arr[i]=new Installment();
			arr[i].setInstallmentNumber(i+1);
			arr[i].setInstallmentAmount(amount/scheme);
			arr[i].setDueDate(LocalDate.now().plusMonths(i+1));
			arr[i].setStatus("Not paid");
			list.add(arr[i]);
			arr[i].setOrder(order);
		}
		
		order.setInstallments(list);
		Order order1=(Order)repo.save(order);
		
		return order1;	
	}
	
	@Transactional
	public void checkCardAmount(String username,int prod_id) {
		Card card=repo.fetchCardByUsername(username);
		Product product=repo.fetch(Product.class, prod_id);
		if(card.getAmountRemaining()<=product.getPrice()) {
			throw new OrderException("Insufficient Balance");
		}
		else {
			card.setAmountRemaining(card.getAmountRemaining()-product.getPrice());
			product.setStockAvailable(product.getStockAvailable()-1);
			repo.save(card);
			repo.save(product);
		}
	}

	

}
