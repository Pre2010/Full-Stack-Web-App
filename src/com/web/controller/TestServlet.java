package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
//	Define datasource/connection pool for Resource Injection
	@Resource(name="jdbc/customer_tracker")
	private DataSource dataSource;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

//		step 1: set up printwriter
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		
//		step 2: get a connection to db
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = dataSource.getConnection();
			
//			step 3: create sql statements
			String sql = "select * from customer";
//			String sql = "select * from customer";
			myStmt = myConn.createStatement();
			
//			step 4: execute sql query
			myRs = myStmt.executeQuery(sql);
			
//			step 5: process the result set
			while (myRs.next()) {
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				String company = myRs.getString("company_name");
				String ipAddress = myRs.getString("ip_address");
				out.println(id);
				out.println(firstName);
				out.println(lastName);
				out.println(email);
				out.println(company);
				out.println(ipAddress);
				
			}	
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
