package com.varxyz.jv251.domain;

@SuppressWarnings("serial")
public class InsufficientBalanceException extends RuntimeException {
	private double balance;
	
	public InsufficientBalanceException(String msg) {
		super(msg);
	}
	
	public InsufficientBalanceException(String msg, double balance) {
		super(msg);
		this.balance = balance;
	}
	
}
