package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

public class NewAccountServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		File f = new File("WEB-INF/jsp/NewAccount.jsp");
		String path = f.getPath();
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		response.setCharacterEncoding("UTF-8");
		User user = new User();
		user.setLogin_id(request.getParameter("login_id"));
		user.setPassword(request.getParameter("password1"));
		int flag = model.DAO.InsertUser(user);
		response.sendRedirect("LoginServlet");
		
		
	}
	
}