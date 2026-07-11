package com.sait.db;
import java.sql.*;
public class createtable {
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/sait","root","Bhairio@12");
			Statement s=c.createStatement();
			s.executeUpdate("create table student(id int primary key auto_increment, name varchar(50), number varchar(50), email varchar(50))");
			System.out.println("Table created successfully");
			c.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
