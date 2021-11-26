package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PageProperty;
import model.Table1;

public class DateDeleteServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		
		request.setCharacterEncoding("UTF-8");
		String page = request.getParameter("page");
		String kind = request.getParameter("kind");
		PageProperty property = new PageProperty();
		property.setPage(Integer.parseInt(page));
		property.setKind(Integer.parseInt(kind));
		
		String id = request.getParameter("id");
		String biz_id = request.getParameter("biz_id");
		String ticket_code = request.getParameter("ticket_code");
		String sales_id = request.getParameter("sales_id");
		Table1 t1 = model.DAO.SelectTable1ById(Integer.parseInt(id));
		
		int flag = model.DAO.DeleteTable27ByBiz_idTicket_codeSales_id(Integer.parseInt(biz_id), ticket_code, Integer.parseInt(sales_id));
		
		request.setAttribute("page", page);
		request.setAttribute("kind", kind);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/TicketServlet");
		dispatcher.forward(request, response);
	}
}