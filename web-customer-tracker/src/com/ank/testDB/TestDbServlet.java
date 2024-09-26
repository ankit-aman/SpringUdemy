package com.ank.testDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user="springstudent";
		String password	="springstudent";
		String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&amp&serverTimezone=UTC";
		String driver="com.mysql.jdbc.Driver";
		
		try {
			PrintWriter printWriter=response.getWriter(); 
			printWriter.println("connecting to DB");
			Class.forName(driver);
			Connection connection=DriverManager.getConnection(jdbcUrl,user,password);
			printWriter.println("Success");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
