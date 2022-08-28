package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlets
 */
@WebServlet("/HelloServlets")
public class HelloServlets extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("uname");
		//System.out.println("Name is ..:"+name);
		ServletOutputStream out=response.getOutputStream();
		out.println("<h1>Name is...:"+name+"</h1>");
		
		if(name.equals("rahim")) {
			response.sendRedirect("welcome.html");//page navigaation bolte isku ..
			
		}else {
			//response.sendRedirect("register.html");
			RequestDispatcher rp=request.getRequestDispatcher("register.html");
			rp.forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
