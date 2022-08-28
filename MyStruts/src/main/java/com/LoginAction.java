package com;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

public class LoginAction extends Action  {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String name=request.getParameter("uname");
		try {
		ServletOutputStream out=response.getOutputStream();
		HttpSession session=request.getSession();
	
			if(session.isNew()) {
				if(name.equals("ramu")) {
    		      
				 return "login.success";//+session.getId());
				}
				else {
					return "login.register";
				}
			
			}else {
					out.println("r u already login......");
				}
			   
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "login.register" ;
	}
}

  
