package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyCustomTag extends TagSupport{
	private String LoginID;
	private String PassWord;

	
	public String getLoginID() {
		return LoginID;
	}
	public void setLoginID(String loginID) {
		LoginID = loginID;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	DBCon dbcon=new DBCon();
	@Override
	public int doEndTag() throws JspException {
		JspWriter out=pageContext.getOut();
		boolean uStatus=dbcon.checkUser(LoginID, PassWord);
		if(LoginID!=""&&PassWord!="") {
			pageContext.getRequest().setAttribute("Auname", LoginID);
			
				if (uStatus) {
					try {
						pageContext.getSession().getAttribute("LoginID");
						RequestDispatcher rd = pageContext.getServletContext().getRequestDispatcher("/welcome.jsp");
						rd.forward(pageContext.getRequest(), pageContext.getResponse());
						}catch(Exception e) {e.printStackTrace();}
				} else {
					
					try {
						if(pageContext.getSession()==null) {
						out.println("You are Already logged in");
						}
						}catch(Exception e) {e.printStackTrace();}
				}
			}else{
				try {
					RequestDispatcher rd = pageContext.getServletContext().getRequestDispatcher("/register.jsp");
					rd.forward(pageContext.getRequest(), pageContext.getResponse());
					}catch(Exception e) {e.printStackTrace();}
			}
		
		
		return super.doEndTag();
	}
	
}