<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.*" import="javax.servlet.http.HttpSession" import="model.Table1" import="java.util.List" import="model.PageProperty"%>
<%File fr = new File("/RegisterServlet");
   String pRegister = fr.getName(); %>
<%File ft = new File("/TicketServlet");
   String pTicket = ft.getName(); 
  HttpSession sess = request.getSession();
  File fl = new File("/TicketList");
  String pList = fl.getName();
  PageProperty  property = (PageProperty)request.getAttribute("page");
  int number = 10*property.getPage();
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<script type="text/javascript" src="js/check.js"></script>
<title>Register</title>
</head>
<body>
  <div class="full-page">
    <h2>チケット一覧</h2>
    <div class="list-parent">
      <%List<Table1> list1 = (List<Table1>)sess.getAttribute("List-Table1");
        for(int i = number - 10;i< number && i<list1.size();i++){
        	int id = list1.get(i).getId();
        	String code = list1.get(i).getTicket_code();
        	String name = list1.get(i).getTicket_name();
        %>
      <div class="select-frame">
        <p><%=code %>：<%=name %></p>
        <input type="button" value="選択" onclick="location.href='<%=pTicket %>?id=<%=id %>'" name="select_btn" class="button">
        
      </div>
      <%} %>
      <div class="select-frame">
        <p>（例）商品番号：チケット名</p>
        <input type="button" value="選択" onclick="location.href='<%=pTicket %>'" name="select_btn" class="button">
        
      </div>
      
      
      <div class="list-flex">
        	<%if(number > 10){ %>
        	<a href="<%=pList %>?page=<%=-1+property.getPage()%>">prev</a><p> |</p>
        	<%}else{ %>
        	<p>prev|</p>
        	<%}if(property.getPage()>3){ %>
        	<a href="<%=pList %>?page=<%=-3+property.getPage()%>"><%=-3+property.getPage() %></a><p>-</p>
        	<%}if(property.getPage()>2){ %>
        	<a href="<%=pList %>?page=<%=-2+property.getPage()%>"><%=-2+property.getPage() %></a><p>-</p>
        	<%}if(property.getPage()>1){ %>
        	<a href="<%=pList %>?page=<%=-1+property.getPage()%>"><%=-1+property.getPage() %></a><p>-</p>
        	<%} %><p><%=property.getPage() %></p>
        	<%if(number < list1.size()){ %>
        	<p>-</p><a href="<%=pList %>?page=<%=1+property.getPage()%>"><%=1+property.getPage() %></a>
        	<%}if((number+10) < list1.size()){ %>
        	<p>-</p><a href="<%=pList %>?page=<%=2+property.getPage()%>"><%=2+property.getPage() %></a>
        	<%}if((number+20) < list1.size()){ %>
        	<p>-</p><a href="<%=pList %>?page=<%=3+property.getPage()%>"><%=3+property.getPage() %></a>
        	<%}if(number < list1.size()){ %><p>| </p><a href="<%=pList %>?page=<%=1+property.getPage() %>" >next</a>
        	<%}else{ %>
        	<p>|next</p>
        	<%} %>
      </div>
    </div>  
  </div>

</body>
</html>