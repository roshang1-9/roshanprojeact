package com.sait.db.ps;
import java.sql.*;

public class ReadData {
	
	public static void main(String[] args) {
		try {
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/sait","root","Bhairio@12");
			PreparedStatement ps=c.prepareStatement("select * from student");
			ps.setname(1, "Shyam");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("number"));
				System.out.println(rs.getString("email"));
				System.out.println("-------------------");
			}
			} catch (Exception e) {	
				
				e.printStackTrace();
			}
		
	}
}