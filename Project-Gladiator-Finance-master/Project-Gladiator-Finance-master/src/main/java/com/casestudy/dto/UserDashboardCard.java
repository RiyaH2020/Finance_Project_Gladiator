package com.casestudy.dto;

import com.casestudy.entity.Card;

public class UserDashboardCard {
	
	private Card card;
	private StatusType status;
	
	public static enum StatusType{
		APPROVED,PENDING,RENEW,UNABLE_TO_RENEW;
	}


	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}
	
	
	
}
