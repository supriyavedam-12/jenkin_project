package com.facebook2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebook2.entity.FacebookEmployee;
import com.facebook2.service.FacebookService;
import com.facebook2.service.FacebookServiceInterface;

/**
 * Servlet implementation class GlobalServlet
 */
public class GlobalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		
		String option = request.getParameter("ac");
		if(option.equals("register"))
		{
			//here name,pass,email,address are the name of html boxes
			String name=request.getParameter("name");
			String pass=request.getParameter("pass");
			String email=request.getParameter("email");
			String address=request.getParameter("address");
			//now servlet want to transfer above data to service so it should
			//transfer in form of object because of DTO design pattern
			//object of ? answer is entity now create entity FacebookEmployee
			//and set all values
			FacebookEmployee fe=new FacebookEmployee();
			fe.setName(name);
			fe.setPass(pass);
			fe.setEmail(email);
			fe.setAddress(address);
			//now pass fe object to service layer how?
			//via object of service layer so create object using 
			//factory design pattern and maintain low coupling via interface
			FacebookServiceInterface fs =FacebookService.createServiceObject();
			//create service object method is a factory method
			int i=fs.createProfile(fe);
			if(i>0)
			{
				out.println("profile created");
			}
			else
			{
				out.println("could not create profile");
			}
			
			
		}
		if(option.equals("login"))
		{
			
		}
		if(option.equals("time")) {
		}
		out.println("</html></body>");
	}
}


