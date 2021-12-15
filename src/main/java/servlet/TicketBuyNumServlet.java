package servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PageProperty;
import model.SumPriceList;

public class TicketBuyNumServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException{
		
		request.setCharacterEncoding("UTF-8");
		PageProperty property = new PageProperty();
		String kind = request.getParameter("kind");
		String page = request.getParameter("page");
		property.setKind(Integer.parseInt(kind));
		property.setPage(Integer.parseInt(page));
		request.setAttribute("property", property);
		
		String FirstDayOfThisMonth = model.CalendarCuliculator.DatetimeThisMonthFirstDay();
		if(request.getParameter("start") != null) {
			FirstDayOfThisMonth = request.getParameter("start") + " 00:00:00";
		}
		
		String LastDayOfThisMonth = model.CalendarCuliculator.DatetimeThisMonthLastDay();
		if(request.getParameter("end") != null) {
			LastDayOfThisMonth = request.getParameter("end") + " 23:59:59";
		}
		
        List<SumPriceList> listS = model.DAO.ViewSumPricesDuringThisMonth(FirstDayOfThisMonth, LastDayOfThisMonth);
        request.setAttribute("listS", listS);
        request.setAttribute("first", FirstDayOfThisMonth.split(" ")[0]);
        request.setAttribute("last", LastDayOfThisMonth.split(" ")[0]);
		
		File f = new File("WEB-INF/jsp/ticketEarnings.jsp");
		String path = f.getPath();
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
}