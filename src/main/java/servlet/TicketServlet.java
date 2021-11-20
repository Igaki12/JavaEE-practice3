package servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Table1;
import model.Table2;
import model.Table7;

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
		String kind = request.getParameter("kind");
		HttpSession session = request.getSession();
		Table1 t1 = (Table1)session.getAttribute("Table1");
		Table2 t2 = new Table2();
		Table7 t7 = new Table7();
				
		if(kind.equals("1")) {
			
			String sales_interval_startDay = request.getParameter("sales_interval_startDay");
			String sales_interval_startTime = request.getParameter("sales_interval_startTime");
			String sales_interval_endDay = request.getParameter("sales_interval_endDay");
			String sales_interval_endTime = request.getParameter("sales_interval_endTime"); 
			String ticket_interval_start = request.getParameter("ticket_interval_start");
			String ticket_interval_end = request.getParameter("ticket_interval_end");
			String ticket_num = request.getParameter("ticket_num");
			String ticket_min_num = request.getParameter("ticket_min_num");
			String ticket_max_num = request.getParameter("ticket_max_num");
			
			int sales_id = 1 + model.DAO.CountTable2ByTicketCode(t1.getTicket_code());
			
			t2.setSales_interval_start(sales_interval_startDay + " " + sales_interval_startTime + ":00");
			t2.setSales_interval_end(sales_interval_endDay + " " + sales_interval_endTime + ":00");
			t2.setBiz_id(1);
			t2.setTicket_code(t1.getTicket_code());
			t2.setSales_id(sales_id);
			
			t7.setBiz_id(1);
			t7.setTicket_code(t1.getTicket_code());
			t7.setSales_id(sales_id);
			t7.setTicket_interval_start(ticket_interval_start + " 00:00:00");
			t7.setTicket_interval_end(ticket_interval_end + " 23:59:59");
			t7.setTicket_days(0);
			t7.setTicket_num(Integer.parseInt(ticket_num));
			t7.setTicket_min_num(Integer.parseInt(ticket_min_num));
			t7.setTicket_max_num(Integer.parseInt(ticket_max_num));
			
			int fault_flag = model.DAO.InsertTable27(t2, t7);
			
		}
		if(kind.equals("2")) {
			String sales_interval_startDay = request.getParameter("sales_interval_startDay");
			String sales_interval_startTime = request.getParameter("sales_interval_startTime");
			String sales_interval_endDay = request.getParameter("sales_interval_endDay");
			String sales_interval_endTime = request.getParameter("sales_interval_endTime"); 
			String ticket_interval_startDay = request.getParameter("ticket_interval_startDay");
			String ticket_num = request.getParameter("ticket_num");
			String ticket_min_num = request.getParameter("ticket_min_num");
			String ticket_max_num = request.getParameter("ticket_max_num");
			String ticket_days = request.getParameter("ticket_days");
			String ticket_interval_endDay = sales_interval_startDay;
			
			int sales_id = 1 + model.DAO.CountTable2ByTicketCode(t1.getTicket_code());
			try{
				ticket_interval_endDay = model.CalendarCuliculator.AddDaysToStrDate(Integer.parseInt(ticket_days),ticket_interval_startDay);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			
			t2.setBiz_id(1);
			t2.setTicket_code(t1.getTicket_code());
			t2.setSales_id(sales_id);
			t2.setSales_interval_start(sales_interval_startDay + " " + sales_interval_startTime + ":00");
			t2.setSales_interval_end(sales_interval_endDay + " " + sales_interval_endTime + ":00");
			
			t7.setBiz_id(1);
			t7.setTicket_code(t1.getTicket_code());
			t7.setSales_id(sales_id);
   		    t7.setTicket_interval_start(ticket_interval_startDay +" 00:00:00");
   		    t7.setTicket_interval_end(ticket_interval_endDay + " 23:59:59");
   		    t7.setTicket_days(Integer.parseInt(ticket_days));
   		    t7.setTicket_num(Integer.parseInt(ticket_num));
   		    t7.setTicket_min_num(Integer.parseInt(ticket_min_num));
   		    t7.setTicket_max_num(Integer.parseInt(ticket_max_num));
   		    
   		    int fault_flag = model.DAO.InsertTable27(t2, t7);
			
		}
		session.removeAttribute("Table1");
		File f = new File("/WEB-INF/jsp/tickets.jsp");
		String path = f.getPath();
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		
	}
	
}