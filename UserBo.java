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
	public List<User> getAllusers() throws Exception
	{
		Connection con = MyConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from user1");
		List<User> li = new ArrayList<User>();
		
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			li.add(new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getDate(6).toLocalDate(),rs.getString(7),rs.getString(8),rs.getInt(9)));
			System.out.println();
		}
		return li;
}
