package com.mphasis.demo.model;

public class Player 
{
	private int playerNumber;
	private int teamNo;
	private String playerName;
	private int noOfMatches;
	private String skill;
	
	public int getPlayerNumber() 
	{
		return playerNumber;
	}
	
	public void setPlayerNumber(int playerNumber) 
	{
		this.playerNumber = playerNumber;
	}
	
	public String getPlayerName() 
	{
		return playerName;
	}
	
	public void setPlayerName(String playerName) 
	{
		this.playerName = playerName;
	}
	
	public int getTeamNo() 
	{
		return teamNo;
	}
	
	public void setTeamNo(int teamNo) 
	{
		this.teamNo = teamNo;
	}
	
	public int getNoOfMatches() 
	{
		return noOfMatches;
	}
	
	public void setNoOfMatches(int noOfMatches) 
	{
		this.noOfMatches = noOfMatches;
	}
	
	public String getSkill() 
	{
		return skill;
	}
	
	public void setSkill(String skill) 
	{
		this.skill = skill;
	}

	public Player(int playerNumber, int teamNo, String playerName,int noOfMatches, String skill) {
		super();
		this.playerNumber = playerNumber;
		this.playerName = playerName;
		this.teamNo = teamNo;
		this.noOfMatches = noOfMatches;
		this.skill = skill;
	}

	public Player() 
	{
		super();
	}

	@Override
	public String toString() 
	{
		return "playerNumber=" + playerNumber + ", playerName=" + playerName + ", teamNo=" + teamNo
				+ ", noOfMatches=" + noOfMatches + ", skill=" + skill;
	}	
}
