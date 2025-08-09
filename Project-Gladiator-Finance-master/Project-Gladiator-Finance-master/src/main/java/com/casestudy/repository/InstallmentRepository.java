package com.casestudy.repository;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import com.casestudy.entity.Card;
import com.casestudy.entity.Installment;
import com.casestudy.entity.Order;
import com.casestudy.entity.RegisteredUser;

@Repository
public class InstallmentRepository extends GenericRepository {

	JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

	
	public int getUserId(String username) {
		return (Integer) entityManager.createQuery("select u.userId from RegisteredUser u where u.username = :uname")
				.setParameter("uname", username).getSingleResult();
	}

	
	public List<Installment> fetchInstallments(String username) {
		int userId = getUserId(username);
		return entityManager.createQuery(
				"select i from RegisteredUser u join u.card c join c.orders o join o.installments i where u.userId = :userid and i.status='Not paid' order by o.orderId, i.dueDate")
				.setParameter("userid", userId).getResultList();

	}

	
	@Transactional
	public void payInstallment(int installmentId, String paymentMode) {
		Installment installment = entityManager.find(Installment.class, installmentId);
		installment.setStatus("Paid");
		installment.setPaidOnDate(LocalDate.now());
		installment.setPaymentMode(paymentMode);
		save(installment);
	}

	
	public Installment isPaid(int orderId) {
		Installment installment = (Installment) entityManager.createQuery(
				"select i from Installment i where i.order.orderId = :orderId and i.status='Not paid' and rownum=1 order by i.dueDate")
				.setParameter("orderId", orderId).getSingleResult();
//		System.out.println(installment.getDueDate());
		return installment;
	}

	
	public boolean installmentPending(int installmentId) {
		Installment installment = entityManager.find(Installment.class, installmentId);
		int installmentNumber = installment.getInstallmentNumber();
		int orderId = installment.getOrder().getOrderId();

		return entityManager.createQuery(
				"select i from Order o join o.installments i where i.installmentNumber < :number and i.status = 'Not paid' and o.orderId = :id ")
				.setParameter("number", installmentNumber).setParameter("id", orderId).getResultList().size() > 0 ? true
						: false;

	}

	
	public List<Order> fetchOrders(String username) {
		int userId = getUserId(username);
		return entityManager.createQuery(
				"select distinct o from RegisteredUser u join u.card c join c.orders o join o.installments i where u.userId = :userid and i.status = 'Not paid' order by o.placedDate ")
				.setParameter("userid", userId).getResultList();
	}

	
	@Transactional
	public void payInstallment2(int orderId, String paymentMode) {
		Installment installment = (Installment) entityManager.createQuery(
				"select i from Installment i where i.order.orderId = :orderId and i.status='Not paid' and rownum=1 order by i.dueDate")
				.setParameter("orderId", orderId).getSingleResult();

		installment.setStatus("Paid");
		installment.setPaidOnDate(LocalDate.now());
		installment.setPaymentMode(paymentMode);
		save(installment);
	}

	public List<Installment> getInstallments(int orderId) {
		return entityManager.createQuery("select i from Installment i where i.order.orderId = :id")
				.setParameter("id", orderId).getResultList();

	}

	public List<Installment> checkForFine(int userId) {
		LocalDate date = LocalDate.now();
		int year = date.getYear();
		Month month = date.getMonth();
		System.out.println(LocalDateTime.of(LocalDate.of(year, month, 1), LocalTime.of(0, 0, 0)));
		return entityManager.createQuery(
				"select i from RegisteredUser u join u.card c join c.orders o join o.installments i where u.userId = :userid and i.status='Not paid' and i.dueDate < :today ")
				.setParameter("userid", userId).setParameter("today", LocalDate.now()).getResultList();
	}

	public void check() {
		List<RegisteredUser> userList = entityManager
				.createQuery("select u from RegisteredUser u where u.status = 'Approved'").getResultList();

		for (RegisteredUser u : userList) {
			List<Installment> installmentList = entityManager.createQuery(
					"select i from RegisteredUser u join u.card c join c.orders o join o.installments i where u.userId = :userid and i.status='Not paid' and i.dueDate < :today ")
					.setParameter("userid", u.getUserId()).setParameter("today", LocalDate.now()).getResultList();

			System.out.println(installmentList.size());

			Card card = (Card) entityManager
					.createQuery("select c from RegisteredUser u join u.card c where u.userId = :userid")
					.setParameter("userid", u.getUserId()).getSingleResult();

			int delayedInstallments = installmentList.size();
			card.setAmountRemaining(card.getAmountRemaining() - delayedInstallments * 10);
			save(card);

//			if(delayedInstallments > 0)
//			{
//				
//				
//				mailSender.setHost("smtp.gmail.com");
//		        mailSender.setPort(587);
//		        mailSender.setUsername("gladiatorfinance2");
//		        mailSender.setPassword("Gladiator@2021");
//		        
//		        Properties javaMailProperties = new Properties();
//		        javaMailProperties.put("mail.smtp.starttls.enable", "false");
//		        javaMailProperties.put("mail.smtp.auth", "true");
//		        javaMailProperties.put("mail.transport.protocol", "smtp");
//		        javaMailProperties.put("mail.debug", "true");
//		        
//		        mailSender.setJavaMailProperties(javaMailProperties);
//		        
//		        MimeMessagePreparator preparator = new MimeMessagePreparator() {
//		            public void prepare(MimeMessage mimeMessage) throws Exception {
//		                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
//		                message.setTo("To");
//		                message.setFrom(mailSender.getUsername());
//		                message.setSubject("Subject");
//		                message.setBcc(mailSender.getUsername());
//		                message.setText("Body", true);
//		            }
//		        };
//		        mailSender.send(preparator);
//
//			} 
		}

	}

	public List<Order> fetchAllOrders(String username) {
		int userId = getUserId(username);
		return entityManager.createQuery(
				"select o from RegisteredUser u join u.card c join c.orders o where u.userId = :userid order by o.placedDate ")
				.setParameter("userid", userId).getResultList();
	}

}
