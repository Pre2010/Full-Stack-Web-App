package com.web.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.web.classes.Customer;

public class CustomerDbUtil {

	private DataSource dataSource;

	public CustomerDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}

	public List<Customer> getCustomers() throws Exception {
//	public ArrayList<Customer> getCustomers() throws Exception{
		System.out.println("at getCustomers() method in Customer DB Util");
		List<Customer> customers = new ArrayList<>();
//		ArrayList<Customer> customers = new ArrayList<>();

		Connection myConn = null;
//		PreparedStatement myStmt = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			System.out.println("in try in CustomerDbUtil");
//			get a connection
			System.out.println("trying to make a connection");
			myConn = dataSource.getConnection();
			System.out.println("connection made from datasource");

//			create sql statement
			String sql = "select * from customer";
			System.out.println("sql string created");

			myStmt = myConn.prepareStatement(sql);
			System.out.println("statement prepared");

//			execute query
			myRs = myStmt.executeQuery(sql);
			System.out.println("sql query executed");

//			process result set
			while (myRs.next()) {
//				retrieve data from the current result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				String company = myRs.getString("company_name");
				String ipAddress = myRs.getString("ip_address");

//				create new customer object
				Customer tempCustomers = new Customer(firstName, lastName, company, email, id, ipAddress);

//				add it to the array list of customers
				customers.add(tempCustomers);
			}
			System.out.println("returned customers");
			return customers;
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

}
