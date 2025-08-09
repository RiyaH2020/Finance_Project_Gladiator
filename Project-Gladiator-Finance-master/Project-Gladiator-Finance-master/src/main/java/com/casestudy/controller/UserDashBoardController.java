package com.casestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.dto.DashBoardUsername;
import com.casestudy.dto.UpdateCard;
import com.casestudy.dto.UserDashBoardProduct;
import com.casestudy.dto.UserDashBoardProduct.ProductStatus;
import com.casestudy.dto.UserDashBoardTransactions;
import com.casestudy.dto.UserDashBoardTransactions.TransactionStatus;
import com.casestudy.dto.UserDashboardCard;
import com.casestudy.dto.UserDashboardCard.StatusType;
import com.casestudy.entity.Card;
import com.casestudy.entity.Installment;
import com.casestudy.entity.Order;
import com.casestudy.entity.Product;
import com.casestudy.exception.NoOrderException;
import com.casestudy.exception.NoTransactionsException;
import com.casestudy.exception.UserApproval;
import com.casestudy.service.UserDashboardService;




@RestController
@CrossOrigin
public class UserDashBoardController {
	
	@Autowired
	private UserDashboardService service;

	@PostMapping("/dashboard")
	public UserDashboardCard viewDashBoardCard(@RequestBody DashBoardUsername dash) {
		
		try {
			Card card= service.viewCardDetails(dash.getUsername());
			UserDashboardCard dstatus=new UserDashboardCard();
			dstatus.setStatus(StatusType.APPROVED);
			dstatus.setCard(card);
			return dstatus;
		}
		catch(UserApproval e) {
			UserDashboardCard dstatus=new UserDashboardCard();
			dstatus.setStatus(StatusType.PENDING);
			dstatus.setCard(null);
			return dstatus;
		}
		
	}
	
	
	@PostMapping("/product")
	public UserDashBoardProduct viewProduct(@RequestBody DashBoardUsername dash){
		try {
			Card card=service.viewCardDetails(dash.getUsername());
			UserDashBoardProduct pstatus=new UserDashBoardProduct();
			List<Product> list= service.viewPurchasedProducts(card);
			List<Order> orders= service.viewOrders(card);
			pstatus.setStatus(ProductStatus.PURCHASED);
			pstatus.setList(list);
			pstatus.setOrders(orders);
			return pstatus;
		}
		catch(NoOrderException e) {
			UserDashBoardProduct pstatus=new UserDashBoardProduct();
			pstatus.setStatus(ProductStatus.NO_HISTORY);
			pstatus.setList(null);
			return pstatus;
		}
		
		
	}
	
	@PostMapping("/recentTransactions")
	public UserDashBoardTransactions viewRecentTransactions(@RequestBody DashBoardUsername dash){
		try{
			Card card=service.viewCardDetails(dash.getUsername());
			UserDashBoardTransactions tstatus=new UserDashBoardTransactions();
			List<Installment> list=service.viewRecentTransactions(card);
			tstatus.setStatus(TransactionStatus.AVAILABLE);
			tstatus.setList(list);
			return tstatus;
		}
		catch(NoTransactionsException e) {
			UserDashBoardTransactions tstatus=new UserDashBoardTransactions();
			tstatus.setStatus(TransactionStatus.NOT_AVAILABLE);
			tstatus.setList(null);
			return tstatus;
		}
	}
	
	@PostMapping("/update")
	public UserDashboardCard updateCard(@RequestBody UpdateCard update) {
		
		try {
			service.updateCard(update.getUsername(),update.getCardType());
			UserDashboardCard dstatus=new UserDashboardCard();
			dstatus.setStatus(StatusType.RENEW);
			return dstatus;
		}
		catch(UserApproval e) {
			UserDashboardCard dstatus=new UserDashboardCard();
			dstatus.setStatus(StatusType.UNABLE_TO_RENEW);
			dstatus.setCard(null);
			return dstatus;
		}
		
	}
}
