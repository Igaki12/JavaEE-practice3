package servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Table1;
import model.Table2;
import model.PageProperty;

public class TicketListServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		request.setCharacterEncoding("UTF-8");
		String page = "1";
		page = request.getParameter("page");
		PageProperty p = new PageProperty();
		try {
			page = request.getParameter("page");
			p.setPage(Integer.parseInt(page));
		}catch (Exception e) {
			p.setPage(1);
		}
		request.setAttribute("page", p);
		
		List<Table2> list2 = model.DAO.SelectAllOfTable2();
		List<Table1> list1 = new ArrayList<Table1>();
		for(Table2 t2 : list2) {
			try{
				Calendar clNow = Calendar.getInstance();
				Calendar clStart = model.CalendarCuliculator.ParseStrDatetimeToCalender(t2.getSales_interval_start());
				Calendar clEnd = model.CalendarCuliculator.ParseStrDatetimeToCalender(t2.getSales_interval_end());
				
				if(clNow.compareTo(clStart) > 0 && clNow.compareTo(clEnd) <= 0) {
					System.out.println(t2.getTicket_code());
					Table1 t1 = model.DAO.SelectTable1ByBiz_idTicket_code(t2.getBiz_id(), t2.getTicket_code());
					
					list1.add(t1);					
				}
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			HttpSession session = request.getSession();
			session.removeAttribute("List-Table1");
			session.setAttribute("List-Table1", list1);
			
		}
		File f = new File("WEB-INF/jsp/list.jsp");
		String path = f.getPath();
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		
	}
}