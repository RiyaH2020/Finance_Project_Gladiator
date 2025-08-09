package com.casestudy.exception;

public class InstallmentException extends RuntimeException{

	public InstallmentException() {
		super();
	}

	public InstallmentException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InstallmentException(String message, Throwable cause) {
		super(message, cause);
	}

	public InstallmentException(String message) {
		super(message);
	}

	public InstallmentException(Throwable cause) {
		super(cause);
	}

}
