package com.varxyz.jv251.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.varxyz.jv251.domain.Customer;

public class CustomerDao {
	
	   public CustomerDao() {}
	   
	   public List<Customer> findAllCustomer() {
		   String sql = "SELECT * FROM Customer";
		   List<Customer> customerList = new ArrayList<Customer>();
		   
	try {	 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	   try {
		   con = DataSourceManager.getConnection();
		   pstmt = con.prepareStatement(sql);
		   rs = pstmt.executeQuery();
		   while(rs.next()) {
			   Customer c = new Customer();
			   c.setCid(rs.getLong("cid"));
			   c.setName(rs.getString("name"));
			   c.setSsn(rs.getString("ssn"));
			   c.setPhone(rs.getString("phone"));
			   c.setPasswd(rs.getString("passwd"));
			   c.setUserId(rs.getString("userId"));
			   customerList.add(c);
		   }
	   }finally {
		   rs.close();
		   pstmt.close();
		   con.close();
	   }
	   }catch(SQLException e) {
		   e.printStackTrace();
	   	}
			return customerList;
	   }
	   
	   /**
	    * 주민번호로 고객 조회
	    * @param ssn
	    * @return
	    */
	   public Customer findCustomerBySsn(String ssn) {
		   String sql = "SELECT * FROM Customer WHERE ssn = ?";
		   List<Customer> customerList = new ArrayList<Customer>();
		   Customer c = null;
	   
		try {	 
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		   try {
			   con = DataSourceManager.getConnection();
			   pstmt = con.prepareStatement(sql);
			   pstmt.setString(1, ssn);
			   rs = pstmt.executeQuery();
			   if(rs.next()) {
				   c = new Customer();
				   c.setCid(rs.getLong("cid"));
				   c.setPasswd(rs.getString("passwd"));
				   c.setName(rs.getString("name"));
				   c.setSsn(rs.getString("ssn"));
				   c.setPhone(rs.getString("phone"));
				   c.setUserId(rs.getString("userId"));
			   }
		   }finally {
			   DataSourceManager.close(rs, pstmt,con);			 
		   	}
		   }catch(SQLException e) {
			   e.printStackTrace();
		   	}
			return c;
		  }
	   
	   /**
	    * 신규 고객등록
	    * @param customer 등록할 고객정보
	    */
	   public void addCustomer(Customer customer) {
		   String sql = "INSERT INTO Customer(name, ssn, phone, userId, passwd)" + " VALUES (?, ?, ?, ?, ?)";
		   
		   try {
			   Connection con = DataSourceManager.getConnection();
			   PreparedStatement pstmt = con.prepareStatement(sql);
			   pstmt.setString(1, customer.getName());
			   pstmt.setString(2, customer.getSsn());
			   pstmt.setString(3, customer.getPhone());
			   pstmt.setString(4, customer.getUserId());
			   pstmt.setString(5, customer.getPasswd());
			   pstmt.executeUpdate();
			   DataSourceManager.close(pstmt, con);
			   System.out.println("INSERTED....");
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
	   }
}
