package com.takeo.dao.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.takeo.User;
import com.takeo.configure.JdbcUtility;
import com.takeo.dao.UserDAO;
import com.takeo.query.QueryConstants;

public class UserDAOImpl implements UserDAO {
	
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	List<User> addUsers=new ArrayList<User>();

	public String register(User user) {
		// TODO Auto-generated method stub
		
		String msg="";
		try {
			con=JdbcUtility.getConnection();
			
			//prepared statement
			ps=con.prepareStatement(QueryConstants.User_Insert_Query);
			
			//set the values
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getUserName());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPassword());
			
		 int count=ps.executeUpdate();
			
			if(count != 0)
				msg="User Information Inserted Successfully";
			else
				msg="User Registration was unsuccessful";
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			try {
				JdbcUtility.closeConnection(con, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return msg;
		

	}
	
	
	public List<User> viewRegister()
	{
		List<User>addUsers=new ArrayList<User>();
		
		try {
			con=JdbcUtility.getConnection();
			
			ps=con.prepareStatement(QueryConstants.User_SELECT_QUERY);
			
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				int uid=rs.getInt(1);
				String firstName=rs.getString(2);
				String lastName=rs.getString(3);
				String userName=rs.getString(4);
				String email=rs.getString(5);
				String password=rs.getString(6);
				
				User user=new User(uid,firstName,lastName,userName,email,password);
				
				addUsers.add(user);
			}
			
			
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			try {
				JdbcUtility.closeConnection(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return addUsers;
	}
	
	
	
	
	
	
	
	
	
	
	
	

	public boolean verifyEmailAndPassword(String email,String password) {
		// TODO Auto-generated method stub
		boolean flag=false;
		
		try {
			con=JdbcUtility.getConnection();
			
			ps=con.prepareStatement(QueryConstants.USER_VALID_QUERY);
			
			//setting values
			ps.setString(1, email);
			ps.setString(2, password);
			
			rs=ps.executeQuery();
			
			if(rs.next())
				flag=true;
			else
				flag=false;
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			try {
				JdbcUtility.closeConnection(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return false;
	}

	public String forgotPassword(String email) {
		// TODO Auto-generated method stub
		
		try {
			con=JdbcUtility.getConnection();
			
			ps=con.prepareStatement(QueryConstants.User_SELECT_QUERY);
			
			//setting values
			rs=ps.executeQuery();
			 
			for(User u: addUsers)
			{
				if(u.getEmail().equals(email))
				{
					return u.getPassword();
				}
			}
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			try {
				JdbcUtility.closeConnection(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}

}
