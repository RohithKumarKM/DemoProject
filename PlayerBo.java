package com.mphasis.demo.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mphasis.demo.connection.MyConnection;
import com.mphasis.demo.model.Player;

public class PlayerBo 
{
	public boolean insertPlayer(Player p) throws Exception
	{
		Connection con = MyConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into player175 values(?,?,?,?,?)");
		ps.setInt(1, p.getPlayerNumber());
		ps.setInt(2, p.getTeamNo());
		ps.setString(3, p.getPlayerName());
		ps.setInt(4,p.getNoOfMatches());
		ps.setString(5, p.getSkill());
		boolean a = ps.execute();
		return a;
	}
	
	public Player getPlayer(int id)throws Exception
	{
		Player p = null;
		Connection con = MyConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from player175 where pno=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			p = new Player(id,rs.getInt(2),rs.getString(3), rs.getInt(4), rs.getString(5));
		}
		return p;
		
	}
	public boolean updatePlayer(Player p) throws Exception
	{
		Connection con = MyConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("update player175 set tno=?,playername=?, nofmatches=?,skill=? where pno=?");
		ps.setInt(1, p.getTeamNo());
		ps.setString(2, p.getPlayerName());
		ps.setInt(3, p.getNoOfMatches());
		ps.setString(4, p.getSkill());
		ps.setInt(5, p.getPlayerNumber());
		boolean a = ps.execute();
		con.commit();
		con.close();
		return a;
	}
	public boolean deletePlayer(Player p) throws Exception
	{
		Connection con = MyConnection.getConnection();
		String a = "delete from player175 where pno=?";
		PreparedStatement ps = con.prepareStatement(a);
		ps.setInt(1, p.getPlayerNumber());
		ps.executeUpdate();
		con.close();
		return true;
	}
	public List<Player> getAllPlayers() throws Exception
	{
		List<Player> al = new ArrayList<Player>();
		Connection con = MyConnection.getConnection();
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from player175");
		while(rs.next())
		{
			al.add(new Player(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
			System.out.println();
		}
		con.close();
		return al;
	}
}
