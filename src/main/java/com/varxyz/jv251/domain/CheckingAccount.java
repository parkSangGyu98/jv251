package com.varxyz.jv251.domain;

import com.varxyz.jv251.exception.InsufficientException;
import com.varxyz.jv251.exception.OverdraftException;

public class CheckingAccount extends Account {
	private double overdraftAmount;
	
	public CheckingAccount() {
		super();
	}
	
	public void withdraw(double amount) { // 마이너스 통장
		if(balance < amount) {
			double overdraftNeeded = amount - balance;
			//잔고 부족시 overdraftAmount 금액 한도 내에서 추가 출금을 승인
			if(overdraftAmount < overdraftNeeded) {
				throw new OverdraftException("에러 : 대월금 초과" , balance , overdraftNeeded);
			}else {
				balance = 0.0;
				overdraftAmount = overdraftAmount - overdraftNeeded;
			}
		}
	}
	
	public double getOverdraftAmount() {
		return overdraftAmount;
	}
	
	public void setOverdraftAmount(double setoverdraftAmount) {
		this.overdraftAmount = setoverdraftAmount;
	}
	
	
	
}