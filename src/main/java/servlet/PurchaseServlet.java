package servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Table1;
import model.Table10;
import model.Table2;
import model.Table5;
import model.Table6;
import model.Table7;
import model.Table8;
import model.Table9;

public class PurchaseServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		String index = request.getParameter("index");
		if(index == null || index =="") {
			index = "1";
		}
		request.setAttribute("index", index);
		HttpSession session = request.getSession();
		session.removeAttribute("index");
		session.setAttribute("index", index);
		List<Table1> list1 = (List<Table1>)session.getAttribute("List-Table1");
		Table1 t1 = list1.get(Integer.parseInt(index));
		List<Table5> itemlist5 = model.DAO.SelectListOfTable5ByBiz_idTicket_code(t1.getBiz_id(), t1.getTicket_code());
		request.setAttribute("itemlist5", itemlist5);
		
		List<Table2> list2 = (List<Table2>)session.getAttribute("List-Table2");
		Table2 t2 = list2.get(Integer.parseInt(index));
		Table7 t7 = model.DAO.SelectTable7ByBiz_idTicket_codeSales_id(t2.getBiz_id(), t2.getTicket_code(), t2.getSales_id());
		request.setAttribute("t7", t7);
		
		
		File f = new File("WEB-INF/jsp/purchase.jsp");
		String path = f.getPath();
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String index = (String) session.getAttribute("index");
		List<Table2> list2 = (List<Table2>)session.getAttribute("List-Table2");
		Table2 t2 = list2.get(Integer.parseInt(index));
//		t2の存在チェック
		Table2 t2_origin = model.DAO.SelectTable2ById(t2.getId());
		if(t2.getBiz_id() != t2_origin.getBiz_id() || t2.getTicket_code().matches(t2_origin.getTicket_code()) == false || t2.getSales_id() != t2_origin.getSales_id()) {
			System.out.println("ERROR:Illegal change was found.");
			System.out.println("t2_origin:" + t2_origin.getBiz_id() + " " + t2_origin.getTicket_code() + " " + t2_origin.getSales_id());
			System.out.println("t2:" + t2.getBiz_id() + " " + t2.getTicket_code() + " " + t2.getSales_id());
			response.sendRedirect("TicketServlet");
		}
		
		Table7 t7 = model.DAO.SelectTable7ByBiz_idTicket_codeSales_id(t2.getBiz_id(), t2.getTicket_code(), t2.getSales_id());
		if(t7 == null) {
			System.out.println("ERROR:Did not exist in Table7 DB.");
			response.sendRedirect("TicketServlet");
		}
		
		List<Table5> list5 = model.DAO.SelectListOfTable5ByBiz_idTicket_code(t2.getBiz_id(), t2.getTicket_code());
		
		Table8 t8_before = new Table8();
		if(null == model.DAO.SelectLatestTable8ByBiz_idTicket_code(t2.getBiz_id(), t2.getTicket_code())) {
			t8_before.setTicket_total_num(0);
		}else {
			t8_before = model.DAO.SelectLatestTable8ByBiz_idTicket_code(t2.getBiz_id(), t2.getTicket_code());
		}
		int[] buy_num = new int[list5.size()];
		int buy_numSum = 0;
		for(int i = 0; i<list5.size(); i++) {
			try {
				buy_num[i] = Integer.parseInt(request.getParameter("buy_num" + (i+1)));
			}catch(Exception e) {
				buy_num[i] = 0;
			}	
			if(request.getParameter("buy_num" + (i+1)) == null || request.getParameter("buy_num" + (i+1)) == "") {
				buy_num[i] = 0;
			}
			buy_numSum += buy_num[i];
		}
//		枚数チェック
		if(buy_numSum > t7.getTicket_num() - t8_before.getTicket_total_num()) {
			System.out.println("ERROR:You chose too many tickets.");
		}
		
		
		Table1 t1 = model.DAO.SelectTable1ByBiz_idTicket_code(t2.getBiz_id(), t2.getTicket_code());
		Table6 t6 = model.DAO.SelectTable6ByBiz_idTicket_code(t2.getBiz_id(), t2.getTicket_code());
		
//		ここから登録
		Table8 t8 = new Table8();
		String unix = String.format("%010d",model.CalendarCuliculator.UnixtimeNow());
		t8.setReserv_code(unix+"0000100");
		t8.setBiz_id(t2.getBiz_id());
		t8.setTicket_code(t2.getTicket_code());
		t8.setSales_id(t2.getSales_id());
		t8.setUser_id(100);
		t8.setTicket_name(t1.getTicket_name());
		t8.setTickets_kind(t1.getTickets_kind());
		t8.setTicket_buyday(model.CalendarCuliculator.StrCalendarNow());
		t8.setTicket_interval_start(t7.getTicket_interval_start());
		t8.setTicket_interval_end(t7.getTicket_interval_end());
		t8.setTicket_start(t7.getTicket_interval_start());
		t8.setTicket_end(t7.getTicket_interval_end());
		t8.setTicket_total_num(buy_numSum + t8_before.getTicket_total_num());
		t8.setCancel_limit_start(t7.getTicket_interval_start());
		t8.setCancel_end(t7.getTicket_interval_end());
		t8.setTicket_status(0);
		
		Table9 t9 = new Table9();
		t9.setReserv_code(t8.getReserv_code());
		t9.setSvc_id(t6.getSvc_id());
		t9.setSvc_name(t6.getSvc_name());
		t9.setSvc_type(t6.getSvc_type());
		t9.setSvc_select_type(t6.getSvc_select_type());
		t9.setSelect_btn_id(0);
		t9.setUsage_time(t6.getUsage_time());
		t9.setSvc_status(0);
		t9.setSvc_start(null);
		t9.setSvc_end(null);
		
		List<Table10> list10 = new ArrayList<Table10>();
		for(int k=0; k<list5.size();k++) {
			Table10 t10 = new Table10();
			t10.setReserv_code(t8.getReserv_code());
			t10.setType_id(list5.get(k).getType_id());
			t10.setType_name(list5.get(k).getType_name());
			t10.setType_money(list5.get(k).getType_money());
			t10.setBuy_num(buy_num[k]);
			t10.setCancel_money(list5.get(k).getCancel_rate());
			if(t10.getBuy_num() != 0) {
			    list10.add(t10);
			}
		}
		
		int flag = model.DAO.InsertTable8to10(t8, t9, list10);
		if(flag != 0) {
			System.out.println("DAO failed to register tickets data.");
			response.sendRedirect("TicketServlet");
		}
		response.sendRedirect("PurchasedServlet");
		
	}
}