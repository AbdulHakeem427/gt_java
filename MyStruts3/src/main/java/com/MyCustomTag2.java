package com;

import javax.servlet.RequestDispatcher;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyCustomTag2 extends TagSupport {
	private String Name,PassWord,Address,loginID;
	
	
	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	private int  Flag;
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPassWord() {
		return PassWord;
	}

	public void setPassWord(String passWord) {
		PassWord = passWord;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	

	public int getFlag() {
		return Flag;
	}

	public void setFlag(int flag) {
		Flag = flag;
	}
	DBCon db=new DBCon();
	@Override
	public int doStartTag() throws JspException {
		JspWriter out=pageContext.getOut();
		int addStatus=db.register(Name, loginID, PassWord, Address,Flag);
		if(addStatus==1) {
			try {
				RequestDispatcher rd = pageContext.getServletContext().getRequestDispatcher("welcome.jsp");
				rd.forward(pageContext.getRequest(), pageContext.getResponse());
				}catch(Exception e) {e.printStackTrace();}
		}else {
			try {
				out.println("Registration Failed ");
				}catch(Exception e) {e.printStackTrace();}
		}
	

		return super.doStartTag();
	}

}
