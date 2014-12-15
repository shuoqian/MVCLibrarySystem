package controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import model.model;
import user.user;

public class controller extends HttpServlet {
	private static final long serialVersionUID=1L;
	private static String INSERT_OR_EDIT="/insert_or_edit.jsp";
	private static String LIST_USER="/listUser.jsp";
	private model dao;
	
	public controller(){
		//super();
		dao = new model();
		System.out.println("controller initiated");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String forward="";
		String action=request.getParameter("action");
		
		if (action.equalsIgnoreCase("delete")){
			int userid=Integer.parseInt(request.getParameter("userid"));
			dao.deleteUser(userid);
			forward=LIST_USER;
			request.setAttribute("users", dao.getAllUsers());
		} else if (action.equalsIgnoreCase("edit")){
			int userid=Integer.parseInt(request.getParameter("userid"));
			user user=dao.getUserByID(userid);
			System.out.println(userid);
			System.out.println(userid);
			System.out.println(userid);
			System.out.println(userid);
			System.out.println(user.userid);
			System.out.println(user.firstName);
			System.out.println(user.lastName);
			System.out.println(user.bookName);
			System.out.println(user.returnDate);
			forward=INSERT_OR_EDIT;
			request.setAttribute("user",user);
		} else if (action.equalsIgnoreCase("listUser")){
			forward=LIST_USER;
			request.setAttribute("users", dao.getAllUsers());
		} else if (action.equalsIgnoreCase("insert")){
			forward=INSERT_OR_EDIT;
		}
		
		RequestDispatcher view=request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		user user = new user();
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setBookName(request.getParameter("bookName"));
		user.setReturnDate(request.getParameter("returnDate"));
		String userid=request.getParameter("userid");
		
		//System.out.println(user.firstName);
		
		if (userid==null||userid.isEmpty()) {
			dao.addUser(user);
		} else {
			user.setUserid(Integer.parseInt(userid));
			dao.updateUser(user);
		}
		RequestDispatcher view=request.getRequestDispatcher(LIST_USER);
		request.setAttribute("users", dao.getAllUsers());
		view.forward(request, response);
	}
}
