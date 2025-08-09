package com.casestudy.repository;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.casestudy.entity.Card;

@Component("order_repo")
public class OrderRepository extends GenericRepository{
	
	public Card fetchCardByUsername(String username) {
		Query q=entityManager.createQuery("select c from Card c join c.registeredUser r where r.username=:uname");
		q.setParameter("uname", username);
		Card c=(Card)q.getSingleResult();
		return c;
	}
	
	public double fetchAmount(int prod_id) {
		Query q=entityManager.createQuery("select p.price from Product p where p.productId=:id");
		q.setParameter("id", prod_id);
		double amount=(Double)q.getSingleResult();
		return amount;
	}

}
