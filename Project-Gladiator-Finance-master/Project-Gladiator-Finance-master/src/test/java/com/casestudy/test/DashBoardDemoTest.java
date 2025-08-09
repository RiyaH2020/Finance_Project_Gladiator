package com.casestudy.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.casestudy.entity.Card;
import com.casestudy.entity.Installment;
import com.casestudy.entity.Product;
import com.casestudy.repository.DashBoardRepository;

public class DashBoardDemoTest {
	
	@Test
	public void fetchCard() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		DashBoardRepository drepo = (DashBoardRepository) ctx.getBean("user-dash");
		Card c=drepo.fetchCardByUsername("riyaH");
		System.out.println(c.getAmountGranted()+" "+c.getAmountRemaining());
	}
	
	@Test
	public void seeOrders() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		DashBoardRepository drepo = (DashBoardRepository) ctx.getBean("user-dash");
		Card c=drepo.fetchCardByUsername("riyaH");
		List<Product> orders=drepo.fetchPurchasedProducts(c);
		System.out.println(orders.size());
		for(Product p:orders)
		{
			System.out.println(p.getProductDetails());
		}
	}
	
	@Test
	public void seeInstallments() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		DashBoardRepository drepo = (DashBoardRepository) ctx.getBean("user-dash");
		Card c=drepo.fetchCardByUsername("riyaH");
		List<Installment> installment=drepo.fetchRecentTransactions(c);
		for(Installment i:installment)
		{
			System.out.println(i.getInstallmentAmount());
		}
		
	}
	
	

}
