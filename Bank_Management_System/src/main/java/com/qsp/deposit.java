package com.qsp;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class deposit {
	public void deposit(int id, double amount) throws Exception {
	    Connection con = DBConnection.getConnection();

	    String update = "UPDATE bank_account SET balance = balance + ? WHERE id=?";
	    PreparedStatement ps = con.prepareStatement(update);
	    ps.setDouble(1, amount);
	    ps.setInt(2, id);
	    ps.executeUpdate();

	    // Insert transaction
	    String txn = "INSERT INTO transactions(account_id, type, amount) VALUES (?, 'deposit', ?)";
	    PreparedStatement ps2 = con.prepareStatement(txn);
	    ps2.setInt(1, id);
	    ps2.setDouble(2, amount);
	    ps2.executeUpdate();

	    System.out.println("Deposited Successfully");
	}

}
