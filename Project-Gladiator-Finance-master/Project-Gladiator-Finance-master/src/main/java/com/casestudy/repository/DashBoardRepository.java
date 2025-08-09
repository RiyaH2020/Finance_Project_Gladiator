package com.casestudy.repository;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.casestudy.entity.Card;
import com.casestudy.entity.Installment;
import com.casestudy.entity.Order;
import com.casestudy.entity.Product;
import com.casestudy.entity.RegisteredUser;

@Component("user-dash")
public class DashBoardRepository extends GenericRepository{

	public boolean isUserApproved(String username)
	{
		Query q=entityManager.createQuery("select u.status from  RegisteredUser u where u.username=:uname");
		q.setParameter("uname", username);
		String status=(String)q.getSingleResult();
		if(status.equals("Approved"))
			return true;
		else
			return false;
	}

	public Card fetchCardByUsername(String username) {
		Query q=entityManager.createQuery("select c from Card c join c.registeredUser r where r.username=:uname");
		q.setParameter("uname", username);
		Card c=(Card)q.getSingleResult();
		return c;
	}

	public List<Product> fetchPurchasedProducts(Card card){
		Query q=entityManager.createQuery("select p from Product p join p.orders o  where o.card=:card");
		q.setParameter("card", card);
		List<Product> orders=q.getResultList();

		return orders;
	}

	public List<Installment> fetchRecentTransactions(Card card){
		Query q=entityManager.createQuery("select i from Installment i join i.order o where i.status=:status and o.card=:card order by i.installmentId desc");
		q.setParameter("status", "Paid");
		q.setParameter("card", card);
		q.setMaxResults(5);
		List<Installment> installments=q.getResultList();

		return installments;
	}

	public List<Order> fetchOrders(Card card){
		Query q=entityManager.createQuery("select o from Order o  where o.card=:card");
		q.setParameter("card", card);
		List<Order> purchases=q.getResultList();

		return purchases;
	}
	
	public RegisteredUser fetchUser(String username){
		Query q=entityManager.createQuery("select r from RegisteredUser r where r.username=:uname");
		q.setParameter("uname", username);
		RegisteredUser user=(RegisteredUser)q.getSingleResult();

		return user;
	}

}


