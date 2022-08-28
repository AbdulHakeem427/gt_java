package com;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ActionController
 */
@WebServlet("*.do")
public class ActionController extends HttpServlet {
	RequestProcessor rp;
	@Override
	public void init(ServletConfig config) throws ServletException {
		rp=new RequestProcessor();
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("uname");
		String pass=request.getParameter("upass");
		DBCon dbcon=new DBCon();
		boolean valid=dbcon.checkUser(name, pass);
		ServletOutputStream out=response.getOutputStream();
		HttpSession session=request.getSession();
		
		if(session.isNew()) {
			
			//out.println("<h1>you are comming for the first time....</h1>");//+session.getId());
			if(valid) {
				   
				out.println( "login.success");
			}
			out.println( "login.register");
		
		}
	
	rp.process(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
