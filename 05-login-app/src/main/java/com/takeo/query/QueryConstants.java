package com.takeo.query;

public interface QueryConstants {
	
	public String User_Insert_Query="insert into user_login(firstName,lastName,userName,email,password)values(?,?,?,?,?)";
	
	public String USER_VALID_QUERY="select *from user_login where email=? and password=?";
	
	public String User_SELECT_QUERY="select *From user_login";

}
