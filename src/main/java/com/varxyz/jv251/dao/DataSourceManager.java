package com.varxyz.jv251.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DataSourceManager { //Java IO == inputStream , outputStream
	private static final String JDBC_URL; //final은 선언과 동시에 초기화를 해줘야한다 , 최소한 객체가 생성되기전에 만들어줘야한다 
	private static final String JDBC_USER;
	private static final String JDBC_PASSWD;
	
	static {
		Properties props = new Properties();
		try {
			props.load(new FileInputStream("jdbc.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Class.forName(props.getProperty("JDBC_DRIVER"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		JDBC_URL = props.getProperty("JDBC_URL");
		JDBC_USER = props.getProperty("JDBC_USER"); 
		JDBC_PASSWD = props.getProperty("JDBC_PASSWD");
		
		System.out.println("JDBC_URL = " + JDBC_URL);
	}
	
	public static void main(String[] args) {
		DataSourceManager manager = new DataSourceManager();
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);
	}
	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if(rs != null) {
			rs.close();
		}
		if(pstmt != null) {
			pstmt.close();
		}
		if(con != null) {
			con.close();
		}
	}
	
	public static void close(PreparedStatement pstmt, Connection con) {
		
	}
	
}

