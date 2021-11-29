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
import model.Table2;
import model.Table5;
import model.Table7;

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
}