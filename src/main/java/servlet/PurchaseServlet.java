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
		if(t2.getBiz_id() != t2_origin.getBiz_id() || t2.getTicket_code() != t2_origin.getTicket_code() || t2.getSales_id() != t2_origin.getSales_id()) {
			System.out.println("ERROR:Illegal change was found.");
		}
		
		Table7 t7 = model.DAO.SelectTable7ByBiz_idTicket_codeSales_id(t2.getBiz_id(), t2.getTicket_code(), t2.getSales_id());
		if(t7 == null) {
			System.out.println("ERROR:Did not exist in Table7 DB.");
		}
		
		int ticket_total_num = model.DAO.SumBuy_total_numFromTable10WhereTable8Ticket_code(t2.getTicket_code());
		
		List<Table5> list5 = model.DAO.SelectListOfTable5ByBiz_idTicket_code(t2.getBiz_id(), t2.getTicket_code());
		
		int[] buy_num = new int[list5.size()];
		int buy_numSum = 0;
		for(int i = 0; i<list5.size(); i++) {
			try {
				buy_num[i] = Integer.parseInt(request.getParameter("buy_num" + i));
			}catch(Exception e) {
				buy_num[i] = 0;
			}	
			if(request.getParameter("buy_num" + i) == null || request.getParameter("buy_num" + i) == "") {
				buy_num[i] = 0;
			}
			buy_numSum += buy_num[i];
		}
//		枚数チェック
		if(buy_numSum > t7.getTicket_num() - ticket_total_num ) {
			System.out.println("ERROR:You bought too many tickets.");
		}
		
	}
}