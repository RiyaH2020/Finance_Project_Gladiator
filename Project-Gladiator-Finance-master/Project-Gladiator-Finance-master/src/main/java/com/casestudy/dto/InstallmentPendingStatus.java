package com.casestudy.dto;

public class InstallmentPendingStatus {
	private boolean isPending;
	private long daysToNextInstallment;
	
	public boolean isPending() {
		return isPending;
	}
	public void setPending(boolean isPending) {
		this.isPending = isPending;
	}
	public long getDaysToNextInstallment() {
		return daysToNextInstallment;
	}
	public void setDaysToNextInstallment(long daysToNextInstallment) {
		this.daysToNextInstallment = daysToNextInstallment;
	}

}
