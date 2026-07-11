package com.sait.db;
import java.sql.*;

public class insertdata {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/sait","root","Bhairio@12");
			Statement s=c.createStatement();
			s.executeUpdate("insert into student(name, number, email) values('Ram', '1234567890','jdk@email.com')");
					System.out.println("Data inserted successfully");
		
		}catch(Exception e) {
			e.printStackTrace();
			
			
		}
	}

}
