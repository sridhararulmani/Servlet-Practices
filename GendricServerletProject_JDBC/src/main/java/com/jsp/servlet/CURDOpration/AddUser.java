package com.jsp.servlet.CURDOpration;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AddUser extends GenericServlet{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int userId=Integer.parseInt(req.getParameter("userID"));
		String userName=req.getParameter("userName");
		String userEmail=req.getParameter("userEmail");
		String userAddress=req.getParameter("userAddress");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/stars5","root","root");
			PreparedStatement pstmt=conn.prepareStatement("INSERT INTO userdetatil VALUES(?,?,?,?);");
			pstmt.setInt(1, userId);
			pstmt.setString(1, userName);
			pstmt.setString(3, userEmail);
			pstmt.setString(4, userAddress);
			int rowsUpdated=pstmt.executeUpdate();
			PrintWriter out=res.getWriter();
			if(rowsUpdated>0) {
				out.print(rowsUpdated+" data Update Succesfully");
			}
			else {
				System.out.println("Somthing Went rong");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}