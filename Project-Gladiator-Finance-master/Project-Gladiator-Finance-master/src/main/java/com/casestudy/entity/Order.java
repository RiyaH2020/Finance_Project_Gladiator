package com.casestudy.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "order_table")
public class Order {

	@Id
	@GeneratedValue
	@Column(name = "order_id")
	private int orderId;
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "placed_date")
	private LocalDate placedDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "receive_date")
	private LocalDate receivedDate;
	
	private double amount;
	
	@Column(name = "emi_scheme")
	private int emiScheme;
	
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "card_number")
	@JsonIgnore
	private Card card;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@OneToMany(mappedBy="order",cascade= {CascadeType.MERGE},fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Installment> installments;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public LocalDate getPlacedDate() {
		return placedDate;
	}

	public void setPlacedDate(LocalDate placedDate) {
		this.placedDate = placedDate;
	}

	public LocalDate getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(LocalDate receivedDate) {
		this.receivedDate = receivedDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getEmiScheme() {
		return emiScheme;
	}

	public void setEmiScheme(int emiScheme) {
		this.emiScheme = emiScheme;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Installment> getInstallments() {
		return installments;
	}

	public void setInstallments(List<Installment> installments) {
		this.installments = installments;
	}
	
	
}
