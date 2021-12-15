<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.*" import="model.Ticket" import="model.DAO" import="java.util.List" import="model.Table1" import="model.PageProperty" import="model.Table2" import="model.Table7"%>
<%File fR = new File("/RegisterServlet");
   String pRegister = fR.getName(); 
   File fD = new File("/RegisterDate");
   String pDate = fD.getName();
   File fl = new File("/TicketList");
   String pList = fl.getName();
   File fT = new File("/TicketServlet");
   String pTicket = fT.getName();
   File fDelete = new File("/DateDelete");
   String pDelete = fDelete.getName();
   File fEdit = new File("/DateEdit");
   String pEdit = fEdit.getName();
   %>
<%List<Table1> list1 = (List<Table1>)request.getAttribute("list1");
PageProperty property = (PageProperty)request.getAttribute("property");
int number = 10*property.getPage();
%>
   
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" href="style.css" />
<title>Tickets</title>
</head>
<body>
  <div class="full-page">
    <div class="main-box">
      <div class="side-menu">
        <a href="<%=pTicket %>?kind=1&page=<%=property.getPage()%>">チケット登録</a><br>
        <p>期間販売登録</p>
        <a href="<%=pTicket %>?kind=3&page=<%=property.getPage()%>">チケット一覧</a><br>
        <a href="<%=pTicket %>?kind=4&page=<%=property.getPage()%>">売上管理</a>
      </div>
      <section>
        <form action="<%=pDate %>" class="register-button-flex" method="get">
          <button class="button" type="submit">新規登録</button>
        </form>
        <table>
          <tr>
            <th>No</th><th>商品<br>番号</th><th>チケット名</th><th>種類</th><th>販売<br>期間</th><th>販売<br>枚数</th><th></th><th></th>
          </tr>
          <%for(int i = number-10; i < list1.size() && i<number; i++){
        	  int id = list1.get(i).getId();
        	  int biz_id = list1.get(i).getBiz_id();
        	  String code = list1.get(i).getTicket_code();
        	  String name = list1.get(i).getTicket_name();
        	  int tickets_kind = list1.get(i).getTickets_kind();
        	  String strKind = "";
        	  if(tickets_kind == 2){
        		 strKind = "指定";
        	  }if(tickets_kind == 1) {
        		 strKind = "フリー";
        	  }
        	  List<Table2> list2 = DAO.SelectListOfTable2ByBiz_idTicket_code(biz_id, code);
        	  List<Table7> list7 = DAO.SelectListOfTable7ByBiz_idTicket_code(biz_id, code);
        	  
        	  int span = Math.min(list2.size(),list7.size());
        	  if(span < 1){
        		  span = 1;
        	  }
        	  %>
          
            <tr><td rowspan="<%=span%>"><%=id %></td><td rowspan="<%=span%>"><%=code %></td><td rowspan="<%=span%>"><%=name %></td><td rowspan="<%=span%>"><%=strKind %></td>
            <%if(Math.min(list2.size(), list7.size()) < 1){%>
                <td></td><td></td>
                <td></td><td></td>
                </tr>
            <%}else{ %>
            <%for (int j=0;j<list2.size()&&j<list7.size();j++){
            	String start = list2.get(j).getSales_interval_start().split(" ")[0];
            	String end = list2.get(j).getSales_interval_end().split(" ")[0];
            	int num = list7.get(j).getTicket_num();%>
            	<%if(j > 0){ %><tr><%} %>
            	<td><h6><%=start %></h6><h6>~<%=end %></h6></td><td><%=num %></td>
            	<td><input class="button" type="button" value="編集" onclick="location.href='<%=pEdit%>?id=<%=id%>&kind=<%=property.getKind()%>&page=<%=property.getPage()%>&biz_id=<%=list2.get(j).getBiz_id()%>&ticket_code=<%=list2.get(j).getTicket_code()%>&sales_id=<%=list2.get(j).getSales_id()%>'"></td>
            	<td><input class="button" type="button" value="削除" onclick="location.href='<%=pDelete%>?id=<%=id%>&kind=<%=property.getKind()%>&page=<%=property.getPage()%>&biz_id=<%=list2.get(j).getBiz_id()%>&ticket_code=<%=list2.get(j).getTicket_code()%>&sales_id=<%=list2.get(j).getSales_id()%>'"></td>
            	</tr>
             
             <%}}}%>
        </table>
        <div class="list-flex">
        	<%if(number > 10){ %>
        	<a href="<%=pTicket %>?page=<%=-1+property.getPage()%>&kind=<%=property.getKind()%>">前</a><p> |</p>
        	<%}else{ %>
        	<p>前|</p>
        	<%}if(property.getPage()>3){ %>
        	<a href="<%=pTicket %>?page=<%=-3+property.getPage()%>&kind=<%=property.getKind()%>"><%=-3+property.getPage() %></a><p>-</p>
        	<%}if(property.getPage()>2){ %>
        	<a href="<%=pTicket %>?page=<%=-2+property.getPage()%>&kind=<%=property.getKind()%>"><%=-2+property.getPage() %></a><p>-</p>
        	<%}if(property.getPage()>1){ %>
        	<a href="<%=pTicket %>?page=<%=-1+property.getPage()%>&kind=<%=property.getKind()%>"><%=-1+property.getPage() %></a><p>-</p>
        	<%} %><p><%=property.getPage() %></p>
        	<%if(number < list1.size()){ %>
        	<p>-</p><a href="<%=pTicket %>?page=<%=1+property.getPage()%>&kind=<%=property.getKind()%>"><%=1+property.getPage() %></a>
        	<%}if((number+10) < list1.size()){ %>
        	<p>-</p><a href="<%=pTicket %>?page=<%=2+property.getPage()%>&kind=<%=property.getKind()%>"><%=2+property.getPage() %></a>
        	<%}if((number+20) < list1.size()){ %>
        	<p>-</p><a href="<%=pTicket %>?page=<%=3+property.getPage()%>&kind=<%=property.getKind()%>"><%=3+property.getPage() %></a>
        	<%}if(number < list1.size()){ %>
        	<p>| </p><a href="<%=pTicket %>?page=<%=1+property.getPage() %>&kind=<%=property.getKind()%>" >次</a>
        	<%}else{ %>
        	<p>|次</p>
        	<%} %>
      </div>
      </section>
    </div>
  </div>
  
  

</body>
</html>