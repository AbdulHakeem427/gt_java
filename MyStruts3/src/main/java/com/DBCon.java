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
	
	public boolean checkUser(String LoginID,String PassWord) {
		
		try {
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost/albunyan","root","root");
			PreparedStatement ps=con.prepareStatement("select * from user_info where LoginID=? and PassWord=?");
			ps.setString(1, LoginID);
			ps.setString(2, PassWord);
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

	public int register(String Name,String LoginID,String PassWord,String Address,int Flag) {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/albunyan","root","root");
			PreparedStatement ps=con.prepareStatement("insert into user_info values (?,?,?,?,?)");
			ps.setString(1, Name);
			ps.setString(2, LoginID);
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