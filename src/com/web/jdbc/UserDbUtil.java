package com.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.web.classes.User;

public class UserDbUtil {

	private DataSource dataSource;

	public UserDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<User> getUsers() throws Exception {
//	public ArrayList<User> getUsers() throws Exception {
		System.out.println("at method getUsers in class UserDbUtil");
		List<User> users = new ArrayList<>();
//		ArrayList<User> users = new ArrayList<>(); 
		
		Connection myConn = null;
//		PreparedStatement myStmt = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			System.out.println("in try in UserDbUtil");
//			get a connection
			System.out.println("trying to make a connection");
			myConn = dataSource.getConnection();
			System.out.println("connection made from datasource");
			
//			create sql statement
			String sql = "select * from user_table";
			System.out.println("sql string created");
			
			myStmt = myConn.prepareStatement(sql);
			System.out.println("statement prepared");
			
//			execute query
			myRs = myStmt.executeQuery(sql);
			System.out.println("sql query executed");
			
//			process result set
			while(myRs.next()) {
//				retrieve data from the current result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				String username = myRs.getString("username");
				String password = myRs.getString("password");
				String role = myRs.getString("role");
				
//				create new user object
				User tempUsers = new User(id, firstName, lastName, email, username, password, role);
				
//				add it to the array list of users
				users.add(tempUsers);
			}
			System.out.println("returned user");
			return users;
		} finally {
			close(myConn, myStmt, myRs);
		}

	}
	
	public void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try {
			if (myRs != null) {
				myRs.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null) {
				myConn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addUser(User theNewUser) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmnt = null;
//	ResultSet myRs = null;

		try {

//	get db connection
			myConn = dataSource.getConnection();

//	create sql statement
			String sql = "insert into user_table " + "(first_name, last_name, email, username, password, role) " + "values (?, ?, ?, ?, ?, ?)";
			myStmnt = myConn.prepareStatement(sql);

//	set the param value for the new user
			myStmnt.setString(1, theNewUser.getFirstName());
			myStmnt.setString(2, theNewUser.getLastName());
			myStmnt.setString(3, theNewUser.getEmail());
			myStmnt.setString(4, theNewUser.getUsername());
			myStmnt.setString(5, theNewUser.getPassword());
			myStmnt.setString(6, theNewUser.getRole());
			
//	execute the sql insert
			myStmnt.execute();

		} finally {
//		clean up the jdbc objects
			close(myConn, myStmnt, null);
		}
	}

}
