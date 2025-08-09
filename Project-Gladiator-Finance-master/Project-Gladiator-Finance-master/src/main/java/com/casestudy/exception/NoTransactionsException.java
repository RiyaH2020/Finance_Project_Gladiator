package com.casestudy.exception;

public class NoTransactionsException extends RuntimeException {

	public NoTransactionsException() {
		super();
	}

	public NoTransactionsException(String message) {
		super(message);
		
	}
	

}
