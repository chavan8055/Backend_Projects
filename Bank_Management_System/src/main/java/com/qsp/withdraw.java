package com.qsp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class withdraw {
	public void withdraw(int id, double amount) throws Exception {
	    Connection con = DBConnection.getConnection();

	    String check = "SELECT balance FROM bank_account WHERE id=?";
	    PreparedStatement ps = con.prepareStatement(check);
	    ps.setInt(1, id);
	    ResultSet rs = ps.executeQuery();

	    if(rs.next()){
	        double balance = rs.getDouble("balance");

	        if(balance < amount){
	            throw new Exception("Insufficient Balance ❌");
	        }

	        String update = "UPDATE bank_account SET balance = balance - ? WHERE id=?";
	        PreparedStatement ps2 = con.prepareStatement(update);
	        ps2.setDouble(1, amount);
	        ps2.setInt(2, id);
	        ps2.executeUpdate();

	        // Transaction record
	        String txn = "INSERT INTO transactions(account_id, type, amount) VALUES (?, 'withdraw', ?)";
	        PreparedStatement ps3 = con.prepareStatement(txn);
	        ps3.setInt(1, id);
	        ps3.setDouble(2, amount);
	        ps3.executeUpdate();

	        System.out.println("Withdraw Successful");
	    }
	}

}
