package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		File f = new File("WEB-INF/jsp/login.jsp");
		String path = f.getPath();
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException{
		request.setCharacterEncoding("UTF-8");
		String login_id = request.getParameter("login_id");
		String password = request.getParameter("password");
		
		int num = model.DAO.CountUserByLogin_idPassword(login_id, password);
		if(num > 0) {
			response.sendRedirect("TicketServlet");
		}else {
			File f = new File("WEB-INF/jsp/login.jsp");
			String path = f.getPath();
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}
	}
}