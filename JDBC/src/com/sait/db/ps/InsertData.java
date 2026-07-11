package com.sait.db.ps;

import java.sql.*;
public class InsertData {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/sait","root","Bhairio@12");
			PreparedStatement ps=c.prepareStatement("insert into student(name, number, email) values(?,?,?)");
					System.out.println("Data inserted successfully");
		ps.setString(1, "Shyam");
		ps.setString(2, "9876543210");
		ps.setString(3, "ram@email.com");
		ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			
			
		}
	}

}

