package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyCustomTag extends TagSupport{
	private int loginID;
	private String passWord;

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getLoginID() {
		return loginID;
	}

	public void setLoginID(int loginID) {
		this.loginID = loginID;
	}
	DBCon dbcon=new DBCon();
	@Override
	public int doEndTag() throws JspException {
		JspWriter out=pageContext.getOut();
		//String pass=request.getParameter("password");
	//	DBCon dbcon=new DBCon();
		boolean valid=dbcon.checkUser(loginID, passWord);
		if(valid) {
			if(valid) {
				   
				try {
					out.println( "login.success");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				out.println("login.register");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	


return super.doEndTag();
}

}