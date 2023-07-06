package com.takeo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.takeo.User;
import com.takeo.dao.impl.UserDAOImpl;

/**
 * Servlet implementation class RegisterController
 */
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("Constructor");
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userId=request.getParameter("userId");
		int userid=Integer.parseInt(userId);
		
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String userName=request.getParameter("userName");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		User user=new User(firstName,lastName,userName,email,password);
		
		//interact with database software to store data
		UserDAOImpl daoimpl=new UserDAOImpl();
		
		String addUsers=daoimpl.register(user);
		
		PrintWriter pw=response.getWriter();
		
		if(addUsers != null)
			pw.println("User Registered Successfully");
		else
			pw.println("Not Inserted");
		
	}

}
