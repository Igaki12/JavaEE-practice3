<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.*" import="model.Ticket" import="model.DAO" import="java.util.List" import="model.Table1" import="model.PageProperty" import="model.Table2" import="model.SumPriceList"%>
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
   File fBN = new File("/TicketBuyNum");
   String pBN = fBN.getName();
   %>
<%
PageProperty property = (PageProperty)request.getAttribute("property");
int number = 10*property.getPage();
String startDayOfSearchRange = (String)request.getAttribute("first");
System.out.println(startDayOfSearchRange);
String endDayOfSearchRange = (String)request.getAttribute("last");
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
        <a href="<%=pTicket %>?kind=2&page=<%=property.getPage() %>">期間販売登録</a><br>
        <a href="<%=pTicket %>?kind=3&page=<%=property.getPage()%>">チケット一覧</a>
        <p>売上管理</p>
      </div>
      <section>
        <form action="<%=pBN %>" class="register-button-flex" method="get">
          <p>売上計算期間　　</p>
          <input type="date" min="2010-01-01" max="2029-12-31" value="<%=startDayOfSearchRange %>" name="start" >
          <p>~</p>
          <input type="date" min="2010-01-01" max="2029-12-31" value="<%=endDayOfSearchRange %>" name="end" >
          <input type="hidden" name="page" value="<%=property.getPage() %>">
          <input type="hidden" name="kind" value="<%=property.getKind() %>">
          <button class="button" type="submit">検索</button>
        </form>
        <table>
          <tr>
            <th>No</th><th>商品番号</th><th>種類</th><th>販売期間</th><th>券種</th><th>価格</th><th>キャンセル料</th><th>売上枚数</th><th>キャンセル料なし</th><th>キャンセル料あり</th><th>合計金額</th><th></th>
          </tr>
          <%List<SumPriceList> listS = (List<SumPriceList>)request.getAttribute("listS");
            if(listS != null){
              for(int i=number-10;i<listS.size()&&i<number;i++){
            	  String tickets_kind = "";
            	  if(listS.get(i).getTickets_kind() == 1){
            		  tickets_kind = "フリー";
            	  }if(listS.get(i).getTickets_kind() == 2){
            		  tickets_kind = "指定";
            	  }
        	  %>
          <tr><td><%=i+1 %></td><td><%=listS.get(i).getTicket_code() %></td><td><%=tickets_kind %></td><td><h6><%=listS.get(i).getTicket_interval_start() %></h6><h6>~<%=listS.get(i).getTicket_interval_end() %></h6></td><td><%=listS.get(i).getType_name() %></td><td><%=listS.get(i).getType_money() %></td><td><%=listS.get(i).getCancel_money() %></td><td><%=listS.get(i).getBuy_num() %></td><td><%=listS.get(i).getCanceled_num_before() %></td><td><%=listS.get(i).getCanceled_num_at_last_moment() %></td><td><%=listS.get(i).getSum_money() %></td>
          <td><input type="button" class="button" value="詳細" onclick=""></td>
          </tr>
          <%}} %>
            
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
        	<%if(number < listS.size()){ %>
        	<p>-</p><a href="<%=pTicket %>?page=<%=1+property.getPage()%>&kind=<%=property.getKind()%>"><%=1+property.getPage() %></a>
        	<%}if((number+10) < listS.size()){ %>
        	<p>-</p><a href="<%=pTicket %>?page=<%=2+property.getPage()%>&kind=<%=property.getKind()%>"><%=2+property.getPage() %></a>
        	<%}if((number+20) < listS.size()){ %>
        	<p>-</p><a href="<%=pTicket %>?page=<%=3+property.getPage()%>&kind=<%=property.getKind()%>"><%=3+property.getPage() %></a>
        	<%}if(number < listS.size()){ %>
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