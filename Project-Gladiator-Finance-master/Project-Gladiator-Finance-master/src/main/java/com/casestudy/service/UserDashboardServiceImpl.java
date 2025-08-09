package com.casestudy.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.entity.Card;
import com.casestudy.entity.Installment;
import com.casestudy.entity.Order;
import com.casestudy.entity.Product;
import com.casestudy.entity.RegisteredUser;
import com.casestudy.exception.NoOrderException;
import com.casestudy.exception.NoTransactionsException;
import com.casestudy.exception.UserApproval;
import com.casestudy.repository.DashBoardRepository;

@Service
@Transactional
public class UserDashboardServiceImpl implements UserDashboardService {

	@Autowired
	private DashBoardRepository userDash;
	public Card viewCardDetails(String username) {

		if(!userDash.isUserApproved(username))
			throw new UserApproval("Approval Pending...");
		else
			return userDash.fetchCardByUsername(username);

	}

	public List<Product> viewPurchasedProducts(Card card){
		if(userDash.fetchPurchasedProducts(card).size()==0) 
			throw new NoOrderException("No purchase history");
		else
			return userDash.fetchPurchasedProducts(card);

	}
	public List<Installment> viewRecentTransactions(Card card){
		if(userDash.fetchRecentTransactions(card).size()==0) 
			throw new NoTransactionsException("No transactions made yet");
		else
			return userDash.fetchRecentTransactions(card);

	}
	public List<Order> viewOrders(Card card){
		if(userDash.fetchOrders(card).size()==0) 
			throw new NoOrderException("No purchase history");
		else
			return userDash.fetchOrders(card);

	}


	public void updateCard(String username, String cardType) {
		if(!userDash.isUserApproved(username))
			throw new UserApproval("Approval Pending...");
		else {
			
			RegisteredUser user=userDash.fetchUser(username);
			Card card=userDash.fetchCardByUsername(username);
			user.setStatus("Renewal");
			user.setCardType(cardType);
			card.setCardType(cardType);
			userDash.save(card);
			userDash.save(user);
		}
	}


}
