package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Table1;

public class TicketDeleteServlet extends HttpServlet{
	
	protected void doGet (HttpServletRequest request,HttpServletResponse response) throws ServletException ,IOException{
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String kind = request.getParameter("kind");
		String page = request.getParameter("page");
		if(kind.equals("3")) {
			
	    }if(kind.equals("2")) {
			
		}else {
			Table1 t1 = model.DAO.SelectTable1ById(Integer.parseInt(id));
			int flag = model.DAO.DeleteTableAllWhereBiz_idTicket_code(t1.getBiz_id(), t1.getTicket_code());
		}
		request.setAttribute("kind", kind);
		request.setAttribute("page", page);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/TicketServlet");
		dispatcher.forward(request, response);
	}
}