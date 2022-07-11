package com.varxyz.jv251.domain;

import java.util.Date;

public abstract class Account {
	protected long aid;
	protected String accountNum;
	protected double balance;
	protected Customer customer;
	protected Date regDate;
	protected char accountType;
	
	public Account() {
		
	}
	
	public Account(String accountNum, double balance) {
		this.accountNum = accountNum;
		this.balance = balance;
	}
	
	public char getAccountType() {
		return accountType;
	}

	public void setAccountType(char accountType) {
		this.accountType = accountType;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public void deposite(String accountNum, double amount) {
		System.out.println("입금 전 금액:"+balance+"원");
		balance += amount;
		System.out.println(amount+"원"+" 입금을 완료했습니다.\n"+"입금 후 금액:"
		+balance+"원\n");
	}
	
	public String getAccountNum() {
		return accountNum;
	}
	
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Customer getCustomer() {
		return this.customer;
	}
	

	public long getAid() {
		return aid;
	}

	public void setAid(long aid) {
		this.aid = aid;
	}
	@Override
	public String toString() {
		return "\n" + accountNum + ", " + balance + ", " + customer.getName() + ", " + customer.getPhone() + ", " + regDate + ", " + aid;
	}
}