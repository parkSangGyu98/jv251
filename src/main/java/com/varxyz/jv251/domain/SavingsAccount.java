package com.varxyz.jv251.domain;

import com.varxyz.jv251.exception.InsufficientException;

public class SavingsAccount extends Account{
	private double interestRate; //이자율
	
	public SavingsAccount() {
		
	}
	
	public SavingsAccount(String accountNum, double balance) {
		this(accountNum, balance, 0.0);
	}
	
	public SavingsAccount(String accountNum, double balance, double interestRate) {
		super(accountNum, balance);
		this.interestRate = interestRate;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public void withdraw(double amount) {
		if(balance - amount < 0) {
//			예외발생
			throw new InsufficientException("잔고 부족");
		}
		System.out.println("출금 전 금액:" + balance+"원");
		balance -= amount; // 부모에게서 balance 호출	
		System.out.println("SavingsAccount에 "+ amount+"원 출금 후 금액: " + balance+"원\n");
	}
	
}