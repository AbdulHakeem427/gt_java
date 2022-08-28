package com;

import java.io.FileInputStream;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestProcessor {
	public void process(HttpServletRequest request,HttpServletResponse response) {
		try {
			//11st prt
		ServletContext app=request.getServletContext();
		String configpath=app.getRealPath("/WEB-INF/config.properties");
		Properties pro=new Properties();
		pro.load(new FileInputStream(configpath));
		
		//2nd
		String formid=request.getParameter("formid");
		String actionclassname=pro.getProperty(formid);
		
		Action action=(Action)Class.forName(actionclassname).newInstance();
		String result=action.execute(request, response);
		
		String nextpage=pro.getProperty(result);
		
		RequestDispatcher rd=request.getRequestDispatcher(nextpage);
		rd.forward(request, response);
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}