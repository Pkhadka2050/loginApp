package com.takeo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.takeo.User;
import com.takeo.dao.impl.UserDAOImpl;

/**
 * Servlet implementation class ForgotController
 */
public class ForgotController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotController() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("Constructor");
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		
		List<User> addUsers=new ArrayList<User>();
		
		
		PrintWriter pw=response.getWriter();
		
		UserDAOImpl daoimpl=new UserDAOImpl();
		
		String verify=daoimpl.forgotPassword(email);
		
		
		
		
	
		for(User u: addUsers)
		{
			if(verify !=null)
			{
				pw.println("Your Password is: "+ u.getPassword());
			}
			else
			{
				pw.println("Email Doesn't Exist");
			}
		}
		
	}

}
