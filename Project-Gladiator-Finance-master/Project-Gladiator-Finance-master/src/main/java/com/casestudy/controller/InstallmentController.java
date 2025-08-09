package com.casestudy.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.dto.InstallmentPendingStatus;
import com.casestudy.dto.InstallmentStatus;
import com.casestudy.dto.Payment;
import com.casestudy.dto.Status;
import com.casestudy.dto.Status.StatusType;
import com.casestudy.entity.Installment;
import com.casestudy.entity.Order;
import com.casestudy.service.InstallmentServiceImpl;

@RestController
@CrossOrigin
public class InstallmentController {

	@Autowired 
	private InstallmentServiceImpl repo;
	 
	@GetMapping(path = "/getinstallments")
	public @ResponseBody List<Installment> getInstallments(@RequestParam("username") String userName)
	{
		return repo.fetchInstallments(userName); 
	}
	
	@PostMapping("/payinstallment")
	public @ResponseBody Status payInstallment(@RequestBody Payment payment)
	{
		System.out.println(payment.getInstallmentid()+" "+payment.getPaymentMode());
		return repo.pay(payment.getInstallmentid(),payment.getPaymentMode());
	}
	
	
	@GetMapping(path = "/getorders")
	public @ResponseBody List<Order> getUnpaidOrders(@RequestParam("username") String userName)
	{
		return repo.fetchOrders(userName); 
	}
	


	@GetMapping(path = "pending")
	public @ResponseBody Status pendingInstallment(@RequestParam("installmentId") int installmentId)
	{
		Status status = new Status();
		
		if(repo.pendingInstallments(installmentId))
		{
			status.setStatus(StatusType.FAILED);
			status.setMessage("Pending EMIs, complete the previous EMIs first");
		}
		else
		{
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("payment valid");
		}
		return status;
	}

	@GetMapping("/isDuePending")
	public @ResponseBody InstallmentPendingStatus isInstallmentPending(@RequestParam("username") String userName) {
		List<Installment> installments = getInstallments(userName);
		InstallmentPendingStatus status = new InstallmentPendingStatus();
		if(installments.size()!=0) {
			LocalDate today = LocalDate.now();
			long noOfDaysBetween = ChronoUnit.DAYS.between(today,installments.get(0).getDueDate());
			status.setDaysToNextInstallment(noOfDaysBetween);
			status.setPending(true);
		}
		else {
			status.setPending(false);
		}
		return status;
	}

	@GetMapping(path = "/getinstallment")
	public @ResponseBody List<Installment> getInstallment(@RequestParam("orderId") int orderId)
	{
		return repo.getInstallments(orderId); 
	}
	
	
	@GetMapping(path = "/check")
	public @ResponseBody List<Installment> check(@RequestParam("userId") int userId)
	{
		return repo.check(userId);
	}
	
	
	
	@GetMapping(path = "/getallorders")
	public @ResponseBody List<Order> getPaidOrders(@RequestParam("username") String userName)
	{
		return repo.getAllOrders(userName); 
	}
	
	
	@GetMapping(path = "/ispaid")
	public @ResponseBody Status IsPaid(@RequestParam("orderId") int orderId)
	{
		Status status = new Status();
		if(repo.isPaid(orderId))
		{
			status.setStatus(StatusType.FAILED);
			status.setMessage("Installment already paid for this month");
		}
		else
		{
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("successfull");
		}
		return status;
	}
	

}
