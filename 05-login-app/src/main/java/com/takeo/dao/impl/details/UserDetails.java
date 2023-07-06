package com.takeo.dao.impl.details;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.takeo.User;
import com.takeo.dao.impl.UserDAOImpl;

public class UserDetails {
	
	UserDAOImpl daoImpl=new UserDAOImpl();
	
	List<User>viewRegister=new ArrayList<User>();
	
	public void UserDetailsMenu()
	{
		Scanner sc=new Scanner(System.in);
		
		while(true)
		{
		
		System.out.println("======================================================");
		System.out.println("                 1) Register User     ");
		System.out.println("                 2) Verify User Email and Password   ");
		System.out.println("                 3) Forgot Password     ");
		System.out.println("======================================================");
		
		System.out.println("Enter Your Choice");
		int choice=sc.nextInt();
		
		switch(choice)
		{
		case 1:
			System.out.println("Enter User First Name");
			String firstName=sc.next();
			System.out.println("Enter User Last Name");
			String lastName=sc.next();
			System.out.println("Enter UserName");
			String userName=sc.next();
			System.out.println("Enter Email");
			String email=sc.next();
			System.out.println("Enter Password");
			String password=sc.next();
			
			User user=new User(firstName,lastName,userName,email,password);
			
			String msg=daoImpl.register(user);
			
			if(msg !=null)
				System.out.println(msg);
			else
				System.out.println(msg);
			
			break;
			
		case 2:
			System.out.println("Enter User Email");
			String email1=sc.next();
			System.out.println("Enter User Password");
			String password1=sc.next();
			
			boolean verify=daoImpl.verifyEmailAndPassword(email1, password1);
			
			if(verify)
			{
				List<User> viewRegister=daoImpl.viewRegister();
				
				for(User u: viewRegister)
				{
					System.out.println(u.getUid()+"\t"+u.getFirstName()+"\t"+u.getLastName()+"\t"+u.getUserName()+"\t"+u.getEmail()+"\t"+u.getPassword());
					
				}
			}
			else
				System.out.println("Invalid Email And Password");
			
			break;
			
		case 3:
			System.out.println("Enter User Email");
			String mail=sc.next();
			daoImpl.forgotPassword(mail);
			
					}
				
		
		}
	}

}
