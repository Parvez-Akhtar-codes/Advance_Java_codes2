package formsInServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println(request.getParameter("name")+"<br/>");
		response.getWriter().println(request.getParameter("gender")+"<br/>");
		PrintWriter out = response.getWriter();
		String[] languages = request.getParameterValues("language");
		if(languages!=null) {
			for(String values : languages) {
				out.print(values+" ");
			}
		}out.print("<br/>");
		response.getWriter().println(request.getParameter("Country")+"<br/>");
	}

}
