package com.takeo.configure;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtility {
	
	

	private static Connection con = null;

	public static Connection getConnection()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Properties pro = new Properties();

		pro.load(new FileInputStream("C:\\Users\\Pravin\\eclipse-workspace\\BJD28\\webdevelopment\\05-login-app\\src\\main\\java\\com\\takeo\\properties\\app.properties"));

		// Step 1: Register Driver
		Class.forName(pro.getProperty("dbClass"));

		// Step 2: Create Connection

		con = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("dbUname"),
				pro.getProperty("dbPassword"));

		return con;

	}

	public static void closeConnection(Connection con, PreparedStatement ps) throws SQLException {
		if (ps != null)
			ps.close();
		if (con != null)
			con.close();
	}

	public static void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) throws SQLException {
		if (ps != null)
			ps.close();
		if (con != null)
			con.close();
		if (rs != null)
			rs.close();

	}


}
