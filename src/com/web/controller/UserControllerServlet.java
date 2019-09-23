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

import com.web.classes.User;
import com.web.jdbc.UserDbUtil;

/**
 * Servlet implementation class UserControllerServlet
 */
@WebServlet("/UserControllerServlet")
public class UserControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDbUtil userDbUtil;
	
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
				listUsers(request,response);
				System.out.println("after the listUsers() from the switch/case but before the break");
				break;
				
			case "ADD":
				System.out.println("switch/case statement for ADD");
				addUsers(request,response);
				System.out.println("after addUsers()");
				break;
				
//			TODO case for DELETE
				
				
//			TODO case for UPDATE
				
				
				
			default:
				System.out.println("in default switch/case");
				listUsers(request,response);
				break;
			}
			
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}

	private void addUsers(HttpServletRequest request, HttpServletResponse response) throws Exception{
//		read user info from form data
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		// create a new user object
		User theNewUser = new User(firstName,lastName,email,username,password,role);
		
		// add the new user to the database
		userDbUtil.addUser(theNewUser);
				
		// send back to main page (the user list)
		listUsers(request, response);
	}

	private void listUsers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("inside the listUsers method");
		
//		Get users from the db util
		System.out.println("attempting to get users from userDbUtil");
		List<User> users = userDbUtil.getUsers();
		
//		ArrayList<User> users = userDbUtil.getUsers();
		
//		add users to the request
		System.out.println("adding the users to the request");
		request.setAttribute("USER_LIST", users);
		
//		send to JSP page (view) /FullStackWebApp/WebContent/jsp/UsersPage.jsp /FullStackWebApp/src/com/web/controller/UserControllerServlet.java
		System.out.println("looking for the UserTable.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/UsersPage.jsp");
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
			userDbUtil = new UserDbUtil(dataSource);
		} catch (Exception e) {
			 throw new ServletException(e);
		}
	}
	
}
