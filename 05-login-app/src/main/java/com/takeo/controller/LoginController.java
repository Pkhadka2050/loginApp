package com.takeo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.takeo.User;
import com.takeo.dao.impl.UserDAOImpl;


/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginController() {
        // TODO Auto-generated constructor stub
    	System.out.println("Constructor");
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userName=request.getParameter("userName");
		
		String password=request.getParameter("password");
		
		//to write the data in browser window
		
		UserDAOImpl daoimpl=new UserDAOImpl();
		
		PrintWriter pw=response.getWriter();
		
		boolean verify=daoimpl.verifyEmailAndPassword(userName, password);
		
		if(verify)
		{
			List<User> viewRegister=daoimpl.viewRegister();
			
			for(User u: viewRegister)
			{
				pw.println(u.getUid()+"\t"+u.getFirstName()+"\t"+u.getLastName()+"\t"+u.getUserName()+"\t"+u.getEmail()+"\t"+u.getPassword());
				
			}
		}
		else
			pw.println("Invalid Email And Password");
		
		
	}

}
