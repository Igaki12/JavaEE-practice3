package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Table1;
import model.Table3;
import model.Table4;
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
		
		model.DAO.InsertTable1(table1);

		Table3 table3 = new Table3();
		table3.setBiz_id(1);
		table3.setTicket_code(request.getParameter("ticket_code"));
		table3.setContents_type(1);
		table3.setContents_index(1);
		table3.setContents_data(request.getParameter("contents_data1"));
		
		model.DAO.InsertTable3(table3);

		
		table3 = new Table3();
		table3.setBiz_id(1);
		table3.setTicket_code(request.getParameter("ticket_code"));
		table3.setContents_type(2);
		table3.setContents_index(1);
		table3.setContents_data(request.getParameter("contents_data2"));
		
		model.DAO.InsertTable3(table3);

		
		Table4 table4 = new Table4();
		table4.setBiz_id(1);
		table4.setTicket_code(request.getParameter("ticket_code"));
		table4.setCautions_type(1);
		table4.setCautions_index(1);
		table4.setCautions_text(request.getParameter("cautions_text1"));
		
		model.DAO.InsertTable4(table4);
//	　　　　ここまで動作確認済み
		
		
		

	}
}