package com.servlet.jdbcDataStoringFromUI;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AddData extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int friendId = Integer.parseInt(req.getParameter("friendId"));
		String friendName = req.getParameter("friendName");
		String friendPlace = req.getParameter("friendPlace");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stars5", "root", "root");
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO userdetail VALUES(?,?,?);");
			pstmt.setInt(1, friendId);
			pstmt.setString(2, friendName);
			pstmt.setString(3, friendPlace);
			int updateResult = pstmt.executeUpdate();
			PrintWriter out = res.getWriter();
			conn.close();

			if (updateResult > 0) {
				out.print(friendName + " Your Update is Done successfully...");
			} else {
				out.print("Somthing went Rong!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}