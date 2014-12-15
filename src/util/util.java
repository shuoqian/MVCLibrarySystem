package util;

import java.sql.*;

public class util {

	private static Connection connection=null;
	public static Connection getConnection(){
		if (connection!=null)
			{System.out.println("hellO");	
			return connection;}
		else{
			try{
				String driver="com.mysql.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/libdb";
				//String url="jdbc:mysql://localhost::3060/libd";
				String username="root";
				String password="root";
				Class.forName(driver);
				connection =DriverManager.getConnection(url,username,password);
			}
			catch(ClassNotFoundException e){e.printStackTrace();}
			catch(SQLException e){e.printStackTrace();}
			
			return connection;
			}
		}
	}
	
