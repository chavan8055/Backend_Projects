package com.qsp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class transactionHistory {
	public void transactionHistory(int id) throws Exception {
	    Connection con = DBConnection.getConnection();
	    String sql = "SELECT * FROM transactions WHERE account_id=?";
	    
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setInt(1, id);

	    ResultSet rs = ps.executeQuery();

	    while(rs.next()){
	        System.out.println(
	            rs.getString("type") + " - " +
	            rs.getDouble("amount") + " - " +
	            rs.getTimestamp("txn_date")
	        );
	    }
	}

}
