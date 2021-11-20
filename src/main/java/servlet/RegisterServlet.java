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

import model.Table1;
import model.Table3;
import model.Table4;
import model.Table5;
import model.Table6;
import model.DAO;

public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		File f = new File("/WEB-INF/jsp/register.jsp");
		String path = f.getPath();
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Table1 table1 = new Table1();
		table1.setBiz_id(1);
		table1.setTicket_code(request.getParameter("ticket_code"));
		table1.setSpot_area_id(1);
		table1.setGenre_code1(request.getParameter("genre_code1"));
		if(request.getParameter("genre_code1") == null)
			table1.setGenre_code1("0");
		table1.setGenre_code2(request.getParameter("genre_code2"));
		if(request.getParameter("genre_code2") == null)
			table1.setGenre_code2("0");
		table1.setTicket_name(request.getParameter("ticket_name"));
		table1.setTicket_remarks(request.getParameter("ticket_remarks"));
		String tickets_kind = request.getParameter("tickets_kind");
		table1.setTickets_kind(Integer.parseInt(tickets_kind));
		String minors_flag = request.getParameter("minors_flag");
		if(request.getParameter("minors_flag") == null)
			minors_flag = "0";
		table1.setMinors_flag(Integer.parseInt(minors_flag));
		table1.setCancel_flag(1);
		String cancel_limit = request.getParameter("cancel_limit");
		table1.setCancel_limit(Integer.parseInt(cancel_limit));
		

		Table3 table3 = new Table3();
		table3.setBiz_id(1);
		table3.setTicket_code(request.getParameter("ticket_code"));
		table3.setContents_type(1);
		table3.setContents_index(1);
		table3.setContents_data(request.getParameter("contents_data1"));
		

		
		Table3 table3_2 = new Table3();
		table3_2.setBiz_id(1);
		table3_2.setTicket_code(request.getParameter("ticket_code"));
		table3_2.setContents_type(2);
		table3_2.setContents_index(1);
		table3_2.setContents_data(request.getParameter("contents_data2"));
		

		
		Table4 table4 = new Table4();
		table4.setBiz_id(1);
		table4.setTicket_code(request.getParameter("ticket_code"));
		table4.setCautions_type(1);
		table4.setCautions_index(1);
		table4.setCautions_text(request.getParameter("cautions_text1"));
		

		Table4 table4_2 = new Table4();
		table4_2.setBiz_id(1);
		table4_2.setTicket_code(request.getParameter("ticket_code"));
		table4_2.setCautions_type(2);
		table4_2.setCautions_index(1);
		table4_2.setCautions_text(request.getParameter("cautions_text2"));
		
		
		Table4 table4_3 = new Table4();
		table4_3.setBiz_id(1);
		table4_3.setTicket_code(request.getParameter("ticket_code"));
		table4_3.setCautions_type(3);
		table4_3.setCautions_index(1);
		table4_3.setCautions_text(request.getParameter("cautions_text3"));
		
		
		
		List<Table5> list5 = new ArrayList<Table5>();
		
		Table5 table5 = new Table5();
		table5.setBiz_id(1);
		table5.setTicket_code(request.getParameter("ticket_code"));
		table5.setType_id(1);
		table5.setType_name(request.getParameter("type_name1"));
		String type_money1 = request.getParameter("type_money1");
		if (request.getParameter("type_money1") == "")
			type_money1 = "0";
		table5.setType_money(Integer.parseInt(type_money1));
		table5.setCancel_type(1);
		String cancel_rate1 = request.getParameter("cancel_rate1");
		if(request.getParameter("cancel_rate1") == "")
			cancel_rate1 = "0";
		table5.setCancel_rate(Integer.parseInt(cancel_rate1));
		list5.add(table5);
		
		int i = 2;
		while (request.getParameter("type_name" + i) != null && request.getParameter("type_name" + i) != "") {
		table5 = new Table5();
		String type_money2 = null;
		String cancel_rate2 = null;
		table5.setBiz_id(1);
		table5.setTicket_code(request.getParameter("ticket_code"));
		table5.setType_id(i);
		table5.setType_name(request.getParameter("type_name" + i));
		System.out.println(request.getParameter("type_money" + i));
		type_money2 = request.getParameter("type_money" + i);
		if (request.getParameter("type_money" + i) == "")
			type_money2 = "0";
		table5.setType_money(Integer.parseInt(type_money2));
		table5.setCancel_type(1);
		cancel_rate2 = request.getParameter("cancel_rate" + i);
		if(request.getParameter("cancel_rate" + i) == "")
			cancel_rate2 = "0";
		table5.setCancel_rate(Integer.parseInt(cancel_rate2));
		list5.add(table5);
		i += 1;
		}
		
		Table6 table6 = new Table6();
		table6.setBiz_id(1);
		table6.setTicket_code(request.getParameter("ticket_code"));
		table6.setSvc_id(1);
		table6.setSvc_name(request.getParameter("svc_name"));
		table6.setSvc_cautions(request.getParameter("svc_cautions"));
		table6.setSvc_type(1);
		String svc_select_type = request.getParameter("svc_select_type");
		if (request.getParameter("svc_select_type") == "")
			svc_select_type = "0";
		table6.setSvc_select_type(Integer.parseInt(svc_select_type));
		
		int fault_flag = model.DAO.InsertTable1to6(table1, table3, table3_2, table4, table4_2, table4_3,list5, table6);
		if(fault_flag == 0 ) {
			System.out.println("Success_insertAll");
		}
		
		File f = new File("/WEB-INF/jsp/tickets.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher(f.getPath());
		dispatcher.forward(request, response);
		

	}
}