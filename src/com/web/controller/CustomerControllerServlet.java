package com.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.web.classes.Customer;
import com.web.jdbc.CustomerDbUtil;


/**
 * Servlet implementation class UserControllerServlet
 */
@WebServlet("/CustomerControllerServlet")
public class CustomerControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CustomerDbUtil customerDbUtil;
	
	@Resource(name="jdbc/customer_tracker")
	private DataSource dataSource;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			String theCommand = request.getParameter("command");
			
//			if command is missing or null, default to LIST
			System.out.println("at doGet method checking for theCommand");
			if(theCommand == null) {
				theCommand = "LIST";
				System.out.println("theCommand is null. Changed to 'LIST'");
			}
			
//			route to appropriate method
			switch (theCommand) {
			case "LIST":
				System.out.println("switch/case statement for LIST");
				listCustomers(request,response);
				System.out.println("after the listUsers() from the switch/case but before the break");
				break;
				
//			TODO case for ADD
				
				
//			TODO case for DELETE
				
				
//			TODO case for UPDATE
				
				
				
			default:
				System.out.println("in default switch/case");
				listCustomers(request,response);
				break;
			}
			
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}

	private void listCustomers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("inside the listCustomers method");
		
//		Get users from the db util
		System.out.println("attempting to get users from customerDbUtil");
		List<Customer> customers = customerDbUtil.getCustomers();
		
//		ArrayList<User> users = userDbUtil.getUsers();
		
//		add users to the request
		System.out.println("adding the users to the request");
		request.setAttribute("CUSTOMER_LIST", customers);
		
//		send to JSP page (view) /FullStackWebApp/WebContent/jsp/UsersPage.jsp /FullStackWebApp/src/com/web/controller/UserControllerServlet.java
		System.out.println("looking for the UserTable.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/CustomersPage.jsp");
//		RequestDispatcher dispatcher = request.getRequestDispatcher("NewFile.jsp");
		dispatcher.forward(request,response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////		 TODO Auto-generated method stub
//		doGet(request, response);
//	}

	@Override
	public void init() throws ServletException{
		super.init();
		
//		create our user db util and pass in the conn pool/datasource
		try {
			customerDbUtil = new CustomerDbUtil(dataSource);
		} catch (Exception e) {
			 throw new ServletException(e);
		}
	}
	
}
