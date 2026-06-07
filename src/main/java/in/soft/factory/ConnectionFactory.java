package in.soft.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory 
{
	private static Connection con= null;
	
	static
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login_db" ,"root", "root");
			
			System.out.println("connection Successfull");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection()
	{
		return con;
	}

}
