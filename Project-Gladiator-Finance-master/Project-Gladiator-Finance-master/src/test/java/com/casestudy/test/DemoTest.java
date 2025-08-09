package com.casestudy.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.casestudy.entity.RegisteredUser;
import com.casestudy.repository.GenericRepository;

public class DemoTest {

	@Test
	public void testingGenericrepository() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		GenericRepository Repo = (GenericRepository) ctx.getBean("user");
		
		RegisteredUser user = new RegisteredUser();
		
		user.setName("Durgen");
		user.setPhoneNumber(1112223332);
		user.setEmail("Durgen@lti");
		user.setPassword("password");
		user.setAddress("Delhi");
		user.setCardType("Gold");
		user.setBankName("SBI");
		user.setAccountNumber(123123);
		user.setIfsc("SBIN123312");
		
		Repo.save(user);
			
	}
	
	@Test
	public void testingDisplayAllUsers() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		GenericRepository Repo = (GenericRepository) ctx.getBean("user");
		
		RegisteredUser user = Repo.fetch(RegisteredUser.class, 110);
		
		System.out.println(user.getName());
	}
}
