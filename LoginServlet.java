package com.mphasis.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.demo.bo.UserBo;
import com.mphasis.demo.model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
   
    public LoginServlet() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String value = request.getParameter("uvalue");
		String pass = request.getParameter("upass");
		
		int flag = 0;
		
		List<User> li = new ArrayList<User>();
		UserBo ub = new UserBo();
		
		try 
		{
			li=ub.getAllusers();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		for(User u:li)
		{
			if(u.getEmail().equals(value))
			{
				if(u.getPassword().equals(pass))
				{
					flag = 1;
					User u1 = new User(u.getEmail(),u.getPassword(),u.getName(),u.getMobile(),u.getLocation(),u.getDob(),u.getSecurityQuestion(),u.getAnswer(),u.getPincode());
					
				}
			}
		}
		RequestDispatcher rd = null;
		if(flag==1)
		{
			rd= request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
		}
		else
		{
			rd = request.getRequestDispatcher("error1.html");
			rd.forward(request, response);
		}
	}

}
