package com.bhavik.springdemo.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDb
 */
@WebServlet("/TestDb")
public class TestDb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jdbcUrl= "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String user="springstudent";
		String pass="springstudent";
		
		String jdbcDriver="com.mysql.jdbc.Driver";
		
		try {
			
			PrintWriter out = response.getWriter();
			
			out.println("Connecting... "+jdbcUrl);
			
			Class.forName(jdbcDriver);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			out.println("Success!!");
			
			myConn.close();
			
		} catch (Exception e) {
			
		}
	}

}
