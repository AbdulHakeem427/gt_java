     package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBCon {
	public DBCon() {
		// TODO Auto-generated constructor stub
	
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean checkUser(int LoginID,String passWord) {
		
		try {
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost/albunyan","root","root");
			PreparedStatement ps=con.prepareStatement("select * from User_details where LoginID=? and passWord=?");
			ps.setInt(1, LoginID);
			ps.setString(2, passWord);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
					return true;
		
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
//	public boolean checkFlag(String uname,String upass) {
//		
//		try {
//			Connection con= DriverManager.getConnection("jdbc:mysql://localhost/albunyan","root","root");
//			PreparedStatement ps=con.prepareStatement("select flag from users where uname=? and upass=?");
//			ps.setString(1, uname);
//			ps.setString(2, upass);
//			ResultSet rs=ps.executeQuery();
//			int f=0;
//			if(rs.next()) {
//				 f=rs.getInt(1);
//			}
//			if (f==0) {
//			 con= DriverManager.getConnection("jdbc:mysql://localhost/albunyan","root","root");
//				PreparedStatement psu=con.prepareStatement("update users set flag=1 where uname=? and upass=?");
//				psu.setString(1, uname);
//				psu.setString(2, upass);
//				psu.executeUpdate();
//				return true;
//			}else {
//				return false;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
//	public boolean reSetFlag(String uname,String upass) {
//		try {
//			Connection con= DriverManager.getConnection("jdbc:mysql://localhost/albunyan","root","root");
//			PreparedStatement psr=con.prepareStatement("update users set flag=0 where uname=? and upass=?");
//			psr.setString(1, uname);
//			psr.setString(2, upass);
//			psr.executeUpdate();
//			return true;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
	public int register(String Name,int LoginID,String PassWord,String Address,int Flag) {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/albunyan","root","root");
			PreparedStatement ps=con.prepareStatement("insert into User_Details values (?,?,?,?,?)");
			ps.setString(1, Name);
			ps.setInt(2, LoginID);
			ps.setString(3,PassWord);
			ps.setString(4, Address);
			ps.setInt(5, Flag);
		 	int i=ps.executeUpdate();
			return i;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}