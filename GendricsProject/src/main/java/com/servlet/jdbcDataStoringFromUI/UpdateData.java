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

public class UpdateData extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String userNameSearch = req.getParameter("userNameSerrch");
		int userId = Integer.parseInt(req.getParameter("userId"));
		String userName = req.getParameter("userName");
		String userEmail = req.getParameter("useremail");
		String userAddress = req.getParameter("userAddress");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stars5", "root", "root");
			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE userdetail SET userId=?,userName=?,userEmail=?,userAddress=? WHERE userName = "
							+ userNameSearch );
			pstmt.setInt(1, userId);
			pstmt.setString(2, userName);
			pstmt.setString(3, userEmail);
			pstmt.setString(4, userAddress);
			int updateResult = pstmt.executeUpdate();
			PrintWriter out = res.getWriter();
			conn.close();
			if (updateResult > 0) {
				out.print(userName + " Your Data Updated Successfully...");
			} else {
				out.print("sothing went Rong!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}