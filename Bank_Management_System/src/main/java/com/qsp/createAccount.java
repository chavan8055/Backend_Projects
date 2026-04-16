package com.qsp;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class createAccount {
	public void createAccount(String name, String email, String password) throws Exception {
	    Connection con = DBConnection.getConnection();
	    String sql = "INSERT INTO bank_account(name, email, password, balance) VALUES (?, ?, ?, 0)";
	    
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setString(1, name);
	    ps.setString(2, email);
	    ps.setString(3, password);
	    
	    ps.executeUpdate();
	    System.out.println("Account Created Successfully");
	}

}
