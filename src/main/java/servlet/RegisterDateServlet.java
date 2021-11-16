package servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Table1;
import model.Table6;

public class RegisterDateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{	
		File f = new File("/WEB-INF/jsp/selectTicket.jsp");
		String path = f.getPath();
		List<Table1> list = model.DAO.SelectAllOfTable1();
		request.setAttribute("list",list);
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("ticket_code");
		int intId = Integer.parseInt(id);
		Table1 t1 = model.DAO.SelectTable1ById(intId);
		Table6 t6 = model.DAO.SelectTable6ByFK(t1.getTicket_code());
		request.setAttribute("Table1", t1);
		request.setAttribute("Table6", t6);
		
		HttpSession session = request.getSession();
		session.setAttribute("Table1", t1);
		
		String path = null;
		if(t1.getTickets_kind() == 1) {
		    File f = new File("/WEB-INF/jsp/registerDate1.jsp");
		    path = f.getPath();
		}
		else if(t1.getTickets_kind() == 2) {
			File f = new File("/WEB-INF/jsp/registerDate2.jsp");
			path = f.getPath();
		}
		else {
			System.out.println("ERROR:tickets_kind");
			File f = new File("/TicketServlet");
			path = f.getPath();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		
	}
	
}