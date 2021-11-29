<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.*" import="javax.servlet.http.HttpSession" import="model.Table1" import="java.util.List" import="model.PageProperty"
import="model.Table3" import="model.Table4"%>
<%File fr = new File("/RegisterServlet");
   String pRegister = fr.getName(); %>
<%File ft = new File("/TicketServlet");
   String pTicket = ft.getName(); 
  HttpSession sess = request.getSession();
  File fl = new File("/TicketList");
  String pList = fl.getName();
  File fp = new File("/PurchaseServlet");
  String pPurchase = fp.getName();
  PageProperty  property = (PageProperty)request.getAttribute("page");
  int number = 10*property.getPage();
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">

<title>Register</title>
</head>
<body>
  <div class="full-page">
    <h2>チケット一覧</h2>
    <div class="list-parent">
      <%List<Table1> list1 = (List<Table1>)sess.getAttribute("List-Table1");
        List<Table3> list3 = (List<Table3>)sess.getAttribute("List-Table3");
        List<Table4> list4 = (List<Table4>)sess.getAttribute("List-Table4");
        
        for(int i = number - 10;i< number && i<list1.size();i++){
        	int id = list1.get(i).getId();
        	String code = list1.get(i).getTicket_code();
        	String name = list1.get(i).getTicket_name();
        	String contents_data2 = list3.get(i).getContents_data();
        	String cautions_text2 = list4.get(i).getCautions_text();
        %>
      <div class="select-frame">
        <p><%=code %>：<%=name %></p>
        <input type="button" value="選択" onclick="modalOpen()" name="select_btn<%=i %>" class="button">
        
      </div>
      <div class="easyModal" id="modal<%=i %>">
        <div class="modal-content">
          <div class="modal-header">
            <h2><%=code %>:<%=name %></h2>
            <span class="modalClose" id="modalClose<%=i %>">×</span>
          </div>
          <div class="modal-body">
　　         <p><%=contents_data2 %></p>
            <p><%=cautions_text2 %></p>
            <input type="button" value="購入へ進む" name="proceed_btn" class="button" onclick="location.href='<%=pPurchase %>?index=<%=i %>'">
          </div>
　       </div>
      </div>
      <%} %>
      
      
     
      
      
      <div class="list-flex">
        	<%if(number > 10){ %>
        	<a href="<%=pList %>?page=<%=-1+property.getPage()%>">前</a><p> |</p>
        	<%}else{ %>
        	<p>前|</p>
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
        	<%}if(number < list1.size()){ %>
        	<p>| </p><a href="<%=pList %>?page=<%=1+property.getPage() %>" >次</a>
        	<%}else{ %>
        	<p>|次</p>
        	<%} %>
      </div>
    </div>  
  </div>

<script type="text/javascript" src="js/ListCheck.js"></script>
</body>
</html>