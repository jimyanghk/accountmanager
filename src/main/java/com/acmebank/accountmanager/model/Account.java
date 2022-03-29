package com.acmebank.accountmanager.model;


import java.math.BigDecimal;

public  class Account {
	private int accountNumber;
	private BigDecimal balance;


	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}
