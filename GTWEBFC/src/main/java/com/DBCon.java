package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBCon {
	public DBCon() {
	     try {
	    	 Class.forName("com.mysql.cj.jdbc.Driver");
	   
	     }catch (Exception e) {
	    	 e.printStackTrace();	    
	    	 }
	}
	public boolean checkUser(String uname,String upass) {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/albunyad","root","root");
			PreparedStatement ps=con.prepareStatement("select * from users where uname=? and upass=?");
			ps.setString(1, uname);
			ps.setString(2, upass);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();	
			}
		return false;
	}

	public int register(int uid,String uname,String upass,String city,int flag ) {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/albunyad","root","root");
			PreparedStatement ps=con.prepareStatement("insert into users values (?,?,?,?,?)");
			ps.setInt(1, uid);
			ps.setString(2, uname);
			ps.setString(3, upass);
			ps.setString(4, city);
			ps.setInt(5, flag);
		 	int i=ps.executeUpdate();
			return i;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}


   public static void main(String []args) {
	   DBCon dbcon=new DBCon();
	   int add=dbcon.register(2, "ram", "secret", "tamil nadu", 0);
	   System.out.println(add+" user add...");
	   System.out.println(dbcon.checkUser("rahim", "secret"));
}
}