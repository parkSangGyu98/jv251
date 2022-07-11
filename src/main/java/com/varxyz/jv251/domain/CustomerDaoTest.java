package com.varxyz.jv251.domain;

import java.util.List;
import com.varxyz.jv251.dao.CustomerDao;

public class CustomerDaoTest {
	public static void main(String[] args) {
		
		CustomerDao dao = new CustomerDao();
		List<Customer> customerList = dao.findAllCustomer();
		for(Customer customer : customerList) {
			System.out.println(customer.toString());
		}
		
		Customer customer = dao.findCustomerBySsn("901234-5678910");
		System.out.println("-------------------------------------------------");
		System.out.println(customer);
		System.out.println("-------------------------------------------------");
	}

}
