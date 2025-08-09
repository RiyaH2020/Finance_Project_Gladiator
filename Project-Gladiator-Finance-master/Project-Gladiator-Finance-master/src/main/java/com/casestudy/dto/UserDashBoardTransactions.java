package com.casestudy.dto;

import java.util.List;

import com.casestudy.entity.Card;
import com.casestudy.entity.Installment;

public class UserDashBoardTransactions {
	private List<Installment> list;
	private TransactionStatus status;
	
	public static enum TransactionStatus{
		AVAILABLE,NOT_AVAILABLE;
	}


	
	public List<Installment> getList() {
		return list;
	}

	public void setList(List<Installment> list) {
		this.list = list;
	}

	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

}
