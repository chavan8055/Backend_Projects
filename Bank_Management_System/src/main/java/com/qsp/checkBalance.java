package com.qsp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class checkBalance {
	public void checkBalance(int id) throws Exception {
	    Connection con = DBConnection.getConnection();
	    String sql = "SELECT balance FROM bank_account WHERE id=?";
	    
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setInt(1, id);

	    ResultSet rs = ps.executeQuery();
	    if(rs.next()){
	        System.out.println("Balance: " + rs.getDouble("balance"));
	    }
	}

}
