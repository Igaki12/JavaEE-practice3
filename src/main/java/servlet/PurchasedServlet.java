package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Table1;
import model.Table2;
import model.Table5;
import model.Table7;

public class PurchasedServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String index = (String) session.getAttribute("index");
		List<Table2> list2 = (List<Table2>)session.getAttribute("List-Table2");
		Table2 t2 = list2.get(Integer.parseInt(index));
		Table7 t7 = model.DAO.SelectTable7ByBiz_idTicket_codeSales_id(t2.getBiz_id(), t2.getTicket_code(), t2.getSales_id());
		if(t7 == null) {
			System.out.println("ERROR:Did not exist in Table7 DB.");
		}
		List<Table5> itemlist5 = model.DAO.SelectListOfTable5ByBiz_idTicket_code(t2.getBiz_id(), t2.getTicket_code());
		
		int[] buy_numArray = new int[itemlist5.size()];
		for(int i = 0; i<itemlist5.size(); i++) {
			try {
				buy_numArray[i] = Integer.parseInt(request.getParameter("buy_num" + i));
			}catch(Exception e) {
				buy_numArray[i] = 0;
			}	
			if(request.getParameter("buy_num" + i) == null || request.getParameter("buy_num" + i) == "") {
				buy_numArray[i] = 0;
			}
		}
		
		
		
		
	}
}