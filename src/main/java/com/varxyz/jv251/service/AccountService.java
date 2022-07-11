package com.varxyz.jv251.service;

import java.util.List;

import com.varxyz.jv251.dao.AccountDao;
import com.varxyz.jv251.domain.Account;

public class AccountService {
	private AccountDao accountDao;
	
	public AccountService(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	public void addAccount(Account account) {
		accountDao.addAccount(account);
	}

	public List<Account> findAllAccount() {
		return accountDao.findAllAccount();
	}
	
//	public static void main(String[] args) { //계좌생성 테스트
//		AccountService service = new AccountService(null);
//		System.out.println(service.generateAccountNum());
//	}
	
	public List<Account> getAccountsBySsn(String ssn){
		return accountDao.findAccountByssn(ssn);
	}
	
	/**
	 * xxx-xx-xxxx 형식의 계좌번호 생성
	 * @return
	 */
	public String generateAccountNum() { //랜덤으로 계좌생성
		String numStr = String.valueOf((int)(Math.random()* 1000000000));
		StringBuilder sb = new StringBuilder();
		sb.append(numStr.substring(0, 3));
		sb.append("-");
		sb.append(numStr.substring(3, 5));
		sb.append("-");
		sb.append(numStr.substring(5));
		return sb.toString();
	}

	public void deposit(String accountNum , double amount) {
		accountDao.deposit(accountNum, amount);
	}
	
	public void withdraw(String accountNum , double amount) {
		accountDao.withdraw(accountNum, amount);
	}
	
}
