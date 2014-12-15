package model;

import util.util;
import user.user;

import java.util.*;
import java.sql.*;

public class model {

	private Connection connection;
	
	public model(){
	connection=util.getConnection();
	System.out.println("connection got finished");
	}
	
	public void addUser(user user){
		try{
			System.out.println("hello1");
			PreparedStatement preparedStatement=connection
					.prepareStatement("insert into users(firstname,lastname,bookname,returndate) values (?, ?, ?, ?)");
			System.out.println("hello2");
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getBookName());
			preparedStatement.setString(4, user.getReturnDate());
			preparedStatement.executeUpdate();
		}
		catch(SQLException e){e.printStackTrace();}
	}
	
	public void deleteUser(int userid){
		try{
			PreparedStatement statement=connection.prepareStatement("delete from users where userid=?");
			statement.setInt(1, userid);
			statement.executeUpdate();
		}
		catch(SQLException e){e.printStackTrace();}	
	}
	
	public void updateUser(user user){
		try{
			PreparedStatement statement=connection.prepareStatement("update users set firstname=?, lastname=?, bookname=?, returndate=? where users.userid=?");
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getBookName());
			statement.setString(4, user.getReturnDate());
			statement.setInt(5, user.getUserid());
			statement.executeUpdate();
		}
		catch(SQLException e){e.printStackTrace();}
	}
	
	public List<user> getAllUsers(){
		List<user> users= new ArrayList<user>();
		try{
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from users");
			while (rs.next())
			{
				user user=new user();
				user.setUserid(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setBookName(rs.getString("bookname"));
				user.setReturnDate(rs.getString("returndate"));
				users.add(user);
			}
		}
		catch(SQLException e){e.printStackTrace();}
		return users;
	}
	
	public user getUserByID(int userid){
		user user=new user();
		try{
			PreparedStatement statement=connection.prepareStatement("select * from users where userid=?");
			statement.setInt(1,userid);
			ResultSet rs=statement.executeQuery();
			
			if (rs.next()){
			user.setUserid(rs.getInt("userid"));
			user.setFirstName(rs.getString("firstname"));
			user.setLastName(rs.getString("lastname"));
			user.setBookName(rs.getString("bookname"));
			user.setReturnDate(rs.getString("returndate"));
			}
		}
		catch(SQLException e){e.printStackTrace();}
		return user;
	}
	
}
