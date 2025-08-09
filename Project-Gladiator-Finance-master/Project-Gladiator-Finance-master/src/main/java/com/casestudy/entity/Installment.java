package com.casestudy.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "installments")
public class Installment {

	@Id
	@GeneratedValue
	@Column(name = "installment_id")
	private int installmentId;
	
	@Column(name = "installment_number")
	private int installmentNumber;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "due_date")
	private LocalDate dueDate;	
	
	String status;
	
	@Column(name = "installment_amount")
	private double installmentAmount;
	
	@Column(name = "payment_mode")
	private String paymentMode;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "paid_on_date")
	private LocalDate paidOnDate;
	
	@ManyToOne
	@JoinColumn(name ="order_id")
	private Order order;
	
	
	public int getInstallmentId() {
		return installmentId;
	}

	public void setInstallmentId(int installmentId) {
		this.installmentId = installmentId;
	}

	public int getInstallmentNumber() {
		return installmentNumber;
	}

	public void setInstallmentNumber(int installmentNumber) {
		this.installmentNumber = installmentNumber;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getInstallmentAmount() {
		return installmentAmount;
	}

	public void setInstallmentAmount(double installmentAmount) {
		this.installmentAmount = installmentAmount;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public LocalDate getPaidOnDate() {
		return paidOnDate;
	}

	public void setPaidOnDate(LocalDate paidOnDate) {
		this.paidOnDate = paidOnDate;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}
