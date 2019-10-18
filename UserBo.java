package com.mphasis.demo.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.mphasis.demo.connection.MyConnection;
import com.mphasis.demo.model.User;

public class UserBo 
{
	public boolean insertPlayer(User u) throws Exception
	{
		Connection con = MyConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into user1 values(?,?,?,?,?,?,?,?,?)");
		ps.setString(1,u.getEmail());
		ps.setString(2, u.getPassword());
		ps.setString(3, u.getName());
		ps.setLong(4, u.getMobile());
		ps.setString(5, u.getLocation());
		 //preparedStatement.setDate ( 1, java.sql.Date.valueOf ( today.minusDays ( 1 ) ) ); 
		ps.setObject(6, java.sql.Date.valueOf(u.getDob()));
		ps.setString(7, u.getSecurityQuestion());
		ps.setString(8, u.getAnswer());
		ps.setInt(9, u.getPincode());
		boolean a = ps.execute();
		return a;
	}
}
