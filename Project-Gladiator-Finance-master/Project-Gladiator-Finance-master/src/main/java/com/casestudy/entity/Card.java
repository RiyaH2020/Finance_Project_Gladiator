package com.casestudy.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "card")
public class Card {

	@Id
	@GeneratedValue
	@Column(name = "card_number")
	private long cardNumber;
	
	@Column(name = "card_type")
	private String cardType;
	
	@Column(name = "amount_granted")
	private double amountGranted;
	
	@Column(name = "amount_remaining")
	private double amountRemaining;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "expiry_date")
	private LocalDate expiry_date;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private RegisteredUser registeredUser;
	
	@OneToMany(mappedBy="card",cascade= {CascadeType.MERGE})
	@JsonIgnore
	private List<Order> orders;

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public double getAmountGranted() {
		return amountGranted;
	}

	public void setAmountGranted(double amountGranted) {
		this.amountGranted = amountGranted;
	}

	public double getAmountRemaining() {
		return amountRemaining;
	}

	public void setAmountRemaining(double amountRemaining) {
		this.amountRemaining = amountRemaining;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(LocalDate expiry_date) {
		this.expiry_date = expiry_date;
	}

	public RegisteredUser getRegisteredUser() {
		return registeredUser;
	}

	public void setRegisteredUser(RegisteredUser registeredUser) {
		this.registeredUser = registeredUser;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
}
