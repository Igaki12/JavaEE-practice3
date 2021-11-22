<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.*" import="model.Ticket" import="model.DAO" import="java.util.List" import="model.Table1" import="model.PageProperty" import="model.Table5"%>
<%File fR = new File("/RegisterServlet");
   String pRegister = fR.getName(); 
   File fD = new File("/RegisterDate");
   String pDate = fD.getName();
   File fl = new File("/TicketList");
   String pList = fl.getName();
   File fT = new File("/TicketServlet");
   String pTicket = fT.getName();
   File fDelete = new File("/TicketDelete");
   String pDelete = fDelete.getName();
   File fEdit = new File("/TicketEdit");
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
        <p>チケット登録</p>
        <a href="<%=pDate %>">期間販売登録</a><br>
        <a href="<%=pList %>">チケット一覧</a>
      </div>
      <section>
        <form action="<%=pRegister %>" class="register-button-flex" method="get">
          <button class="button" type="submit">新規登録</button>
        </form>
        <table>
          <tr>
            <th>No</th><th>商品番号</th><th>チケット名</th><th>金額</th><th></th><th></th>
          </tr>
          <%for(int i = number-10; i < list1.size() && i<number; i++){
        	  int id = list1.get(i).getId();
        	  int biz_id = list1.get(i).getBiz_id();
        	  String code = list1.get(i).getTicket_code();
        	  String name = list1.get(i).getTicket_name();
        	  List<Table5> list5 = DAO.SelectListOfTable5ByBiz_idTicket_code(biz_id, code);
        	  %>
          
            <tr><td><%=id %></td><td><%=code %></td><td><%=name %></td><td>
            <%for (Table5 t5: list5){
            	String type = t5.getType_name();
            	int money = t5.getType_money();
            	%><h6><%=type%>:<%=money%>円</h6>
            <%} %></td>
            <td><input class="button" type="button" value="編集" onclick="location.href='<%=pEdit%>?id=<%=id%>&kind=<%=property.getKind()%>&page=<%=property.getPage()%>'"></td><td><input class="button" type="button" value="削除" onclick="location.href='<%=pDelete%>?id=<%=id%>&kind=<%=property.getKind()%>&page=<%=property.getPage()%>'"></td></tr>
          
          <%} %>
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