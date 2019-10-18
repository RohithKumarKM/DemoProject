package com.mphasis.demo.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.demo.bo.UserBo;
import com.mphasis.demo.model.User;

/**
 * Servlet implementation class InsertUserServlet
 */
@WebServlet("/InsertUserServlet")
public class InsertUserServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
      
    public InsertUserServlet() 
    {
        super();
    }
	public void init(ServletConfig config) throws ServletException 
	{
	
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		long mobile = Long.parseLong(request.getParameter("mobile"));
		String location = request.getParameter("location");
		
		String dob = request.getParameter("dob");
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("ddMMyyyy");
		LocalDate localDate_dob= LocalDate.parse(dob,formatter);
		
		String securityQuestion = request.getParameter("securityQ");
		String answer = request.getParameter("answer");
		int pincode = Integer.parseInt(request.getParameter("pincode"));
		
		UserBo ub = new UserBo();
		User u = new User(email,password,name,mobile,location,localDate_dob,securityQuestion,answer,pincode);
		
		boolean b = false;
		
		RequestDispatcher rd = null;
		
		try
		{
			b = ub.insertPlayer(u);
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
