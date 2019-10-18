package com.mphasis.demo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.demo.bo.PlayerBo;
import com.mphasis.demo.model.Player;

@WebServlet("/InsertPlayerServlet")
public class InsertPlayerServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public InsertPlayerServlet() 
    {
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int playerid = Integer.parseInt(request.getParameter("pid"));
		String name = request.getParameter("pname");
		int teamno = Integer.parseInt(request.getParameter("pteamid"));
		int nom = Integer.parseInt(request.getParameter("pno"));
		String skill = request.getParameter("pskill");
		
		System.out.println(playerid+"  "+name+" "+teamno+" "+skill+" "+nom);
		
		PlayerBo pb = new PlayerBo();
		Player p = new Player(playerid,teamno,name,nom,skill);
		
		boolean b = false;
		
		RequestDispatcher rd = null;
		
		try
		{
			b = pb.insertPlayer(p);
		}
		catch (Exception e) 
		{
			b=true;
			rd=request.getRequestDispatcher("error.html");
			rd.forward(request, response);
			System.out.println("Error due to"+e);
		}
		if(b==false)
		{
			rd = request.getRequestDispatcher("success.html");
			rd.forward(request, response);
			System.out.println("Inserted Successfully");
		}
		
	}
}
