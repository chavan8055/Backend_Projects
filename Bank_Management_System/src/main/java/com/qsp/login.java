package com.qsp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class login {
	public int login(String email, String password) throws Exception {
	    Connection con = DBConnection.getConnection();
	    String sql = "SELECT id FROM bank_account WHERE email=? AND password=?";
	    
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setString(1, email);
	    ps.setString(2, password);

	    ResultSet rs = ps.executeQuery();

	    if(rs.next()){
	        return rs.getInt("id"); // login success
	    } else {
	        return -1;
	    }
	}

}
