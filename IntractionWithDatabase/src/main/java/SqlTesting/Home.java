package SqlTesting;

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

@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page").toLowerCase();
		switch (page) {
		case "home": {
			request.setAttribute("title", "Homepage");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;
			
		}
		case "listusers": {
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
			break;
			
		}
		default:
			request.setAttribute("title", "Error");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			break;
		}
	}

	
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
