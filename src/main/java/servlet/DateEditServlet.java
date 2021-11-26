package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PageProperty;
import model.Table1;
import model.Table2;
import model.Table6;
import model.Table7;

public class DateEditServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException ,IOException{
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
		Table6 t6 = model.DAO.SelectTable6ByBiz_idTicket_code(Integer.parseInt(biz_id), ticket_code);
		
		Table2 t2 = model.DAO.SelectTable2ByBiz_idTicket_codeSales_id(Integer.parseInt(biz_id), ticket_code, Integer.parseInt(sales_id));
		Table7 t7 = model.DAO.SelectTable7ByBiz_idTicket_codeSales_id(Integer.parseInt(biz_id), ticket_code, Integer.parseInt(sales_id));
		
		request.setAttribute("Table1", t1);
		request.setAttribute("Table2", t2);
		request.setAttribute("Table6", t6);
		request.setAttribute("Table7", t7);
		request.setAttribute("property", property);
		
		File f = new File("/WEB-INF/jsp/editDate1");
		if(t1.getTickets_kind() == 2) {
			f = new File("/WEB-INF/jsp/editDate2");
		}
		String path = f.getPath();
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		
	}
}