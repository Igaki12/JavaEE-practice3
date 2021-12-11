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
   File fPurchase = new File("/PurchaseServlet");
   String pPurchase = fPurchase.getName();
   
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
  <div class="list-parent">
    <h3>ありがとうございました。</h3>
    <br>
    <br>
    <br>
    <button class="button" type="button" onclick="location.href='<%=pTicket %>'">チケット一覧へ</button>
  </div>
  　　
</div>
</body>
</html>