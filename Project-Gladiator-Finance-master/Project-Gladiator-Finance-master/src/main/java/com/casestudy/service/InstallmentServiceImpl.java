package com.casestudy.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.casestudy.dto.Status;
import com.casestudy.dto.Status.StatusType;
import com.casestudy.entity.Installment;
import com.casestudy.entity.Order;
import com.casestudy.repository.InstallmentRepository;

@EnableAsync
@EnableScheduling
@Service
public class InstallmentServiceImpl {

	@Autowired
	private InstallmentRepository installmentRepository;

//	public InstallmentStatus payInstallment(int installmentId, String paymentMode) {
//		try {
//			if (installmentRepository.isPaid(installmentId))
//				throw new InstallmentException("installment already paid");
//			InstallmentStatus status = new InstallmentStatus();
//			installmentRepository.payInstallment(installmentId, paymentMode);
//			status.setInstallmentId(installmentId);
//			status.setPaymentMode(paymentMode);
//			status.setStatus(StatusType.SUCCESS);
//			status.setMessage("installment paid");
//			return status;
//		} catch (Exception e) {
//			InstallmentStatus status = new InstallmentStatus();
//			status.setInstallmentId(installmentId);
//			status.setStatus(StatusType.FAILED);
//			return status;
//		}
//	}

	public List<Installment> fetchInstallments(String username) {
		return installmentRepository.fetchInstallments(username);
	}

	public boolean pendingInstallments(int installmentId) {
		return installmentRepository.installmentPending(installmentId);
	}

	public List<Order> fetchOrders(String username) {
		try {
			return installmentRepository.fetchOrders(username);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Status pay(int orderId, String paymentMode) {
		Status status = new Status();
		try {
			installmentRepository.payInstallment2(orderId, paymentMode);
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("installment paid");
			return status;
		} catch (Exception e) {
			status.setStatus(StatusType.FAILED);
			status.setMessage("not paid");
			return status;
		}
	}
	
	
	public List<Installment> getInstallments(int orderId)
	{
		return installmentRepository.getInstallments(orderId);
	}
	
	
	public List<Installment> check(int userId)
	{
		 return installmentRepository.checkForFine(userId);
	}
	
	
	@Transactional
	@Async
	@Scheduled(cron = "0 0 12 * * ?")
	public void InstallmentFine()
	{
		installmentRepository.check();
	}
	
	
	public List<Order> getAllOrders(String username)
	{
		try {
			
			return installmentRepository.fetchAllOrders(username);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public boolean isPaid(int orderId)
	{
		Installment installment = installmentRepository.isPaid(orderId);
		Month dueMonth = installment.getDueDate().getMonth();
		Month currentMonth = LocalDate.now().getMonth();
		System.out.println(dueMonth +" "+ currentMonth);
		int dueYear = installment.getDueDate().getYear();
		int currentYear = LocalDate.now().getYear();
		if((dueMonth.getValue() > currentMonth.getValue()) && currentYear==dueYear && installment.getInstallmentNumber()!=1)
			return true;
		else
			return false;
	}
}
