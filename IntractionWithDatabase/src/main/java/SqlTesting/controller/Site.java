package SqlTesting.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import SqlTesting.entity.User;
import SqlTesting.model.UserModel;


@WebServlet("/site")
public class Site extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page").toLowerCase();
		switch (page) {
		
		case "listusers": {
			listusers(request, response);
			break;
			
		}
		
		case "adduser" : {
			adduser(request, response);
			break;
		}
		
		case "updateuser" : {
			updateuser(request , response);
			break;
		}
		case "deleteuser" : {
			try {
				new UserModel().deleteUser(Integer.parseInt(request.getParameter("user_id")));
			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			listusers(request, response);
			break;
		}
		
		default:
			request.setAttribute("title", "Error");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String form = request.getParameter("form").toLowerCase();
		switch (form) {
		
		case "adduseroperation": {
			User user  = new User(request.getParameter("username"),request.getParameter("email_id"));
			try {
				new UserModel().addUser(user);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			listusers(request, response);
			break;
			
		 }
		case "updateuseroperation" : {
			User updated_user = new User(Integer.parseInt(request.getParameter("user_id")), request.getParameter("username")
					, request.getParameter("email_id"));
			try {
				new UserModel().updateUser(updated_user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			listusers(request,response);
			break;
		}
		default:
			request.setAttribute("title", "Error");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			break;
		
		}
	}
	
	
	protected void listusers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users = new ArrayList<>();
		try {
			users = new UserModel().listuser();
			request.setAttribute("listusers", users);
			request.setAttribute("title", "List Users");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("listusers.jsp").forward(request, response);
	}
	
	protected void adduser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "Add user");
		request.getRequestDispatcher("adduser.jsp").forward(request, response);
	}
	protected void updateuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "Update user");
		request.getRequestDispatcher("updateuser.jsp").forward(request, response);
	}
	

}
