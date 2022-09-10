package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginAction extends Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)  {
		String uname=request.getParameter("uname");
		String upass=request.getParameter("upass");
		////PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		DBCon dbcon=new DBCon();
		boolean valid=dbcon.checkUser(uname, upass);
		//HttpSession session=request.getSession();
		//session.setAttribute("username", name);
		if(valid) {
			
			return "login.success";
		}
		return "login.register";
		
		


		
	}
	}
	

