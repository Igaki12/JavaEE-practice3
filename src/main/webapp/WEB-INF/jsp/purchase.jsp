<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.*" import="model.Ticket" import="model.DAO" import="java.util.List" import="model.Table1" import="model.Table7" import="model.PageProperty" import="model.Table5"%>
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
   
   HttpSession sess = request.getSession();
   %>
<%
List<Table1> list1 = (List<Table1>)sess.getAttribute("List-Table1");
Table7 t7 = (Table7)request.getAttribute("t7");
List<Table5> itemlist5 = (List<Table5>)request.getAttribute("itemlist5");
%>
   
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" href="style.css" />
<title>Tickets</title>
</head>
<body>
<div class="full-page-purchase">
  <h2>チケット購入</h2>
  <form class="list-parent" action="?item=<%=itemlist5.size() %>" method="post">
  　　<h3>枚数を選択する</h3>
    <%for(Table5 t5: itemlist5){%>
      <div class="list-flex">
        <h4><%=t5.getType_name() %>:</h4>
        <p id="price<%=t5.getType_id() %>"><%=t5.getType_money() %></p>円
      </div>
      <input id="input<%=t5.getType_id() %>" type="number" name="buy_num<%=t5.getType_id() %>" min="0" max="<%=t7.getTicket_max_num() %>">
      
    <%} %>
    <div class="list-flex">
      <h4>合計</h4><p id="sum_price">-</p><p>円</p>
    </div>
    <input type="submit" value="購入する" class="button">
    <br>
    <br>
    <br>
    
  </form>


</div>
<script type="text/javascript" src="js/purchase.js"></script>
</body>
</html>