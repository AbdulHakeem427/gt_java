package com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterAction extends Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
	    String Name=request.getParameter("Name");
		String  LoginID=request.getParameter("LoginId");
		String PassWord=request.getParameter("PassWord");
		String Address=request.getParameter("Address");
		int Flag=Integer.parseInt(request.getParameter("Flag"));
		
		DBCon dbcon=new DBCon();
		int add=dbcon.register(Name, LoginID, PassWord, Address, Flag);
		if(add==1) {
		return "register.success";
	}
		else {
		
		return "register.failure";
		
		}
		
		}

}
