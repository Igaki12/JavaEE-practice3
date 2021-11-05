package servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Ticket;

public class TicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException ,IOException{
		File f = new File("/WEB-INF/jsp/tickets.jsp");
		String path = f.getPath();
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request,response);
	}
	protected void doPost (HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String ticket_name = null;
		String ticket_code = null;
		String type_money1 = null;
		
		ticket_name = request.getParameter("ticket_name");
	    ticket_code = request.getParameter("ticket_code");
		type_money1 = request.getParameter("type_money1");
		
		Ticket ticket = new Ticket();
		HttpSession session = request.getSession();
		ticket.setTicket_code(ticket_code);
		ticket.setTicket_name(ticket_name);
		ticket.setType_money1(type_money1);
		
		
		session.setAttribute("ticket", ticket);
		
		File f = new File("/WEB-INF/jsp/tickets.jsp");
		String path = f.getPath();
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		
		
		
		
	}
	
}