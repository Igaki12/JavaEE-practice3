<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.*" import="model.Ticket" %>
<%File f = new File("/RegisterServlet");
   String path = f.getName(); %>
<%
String ticket_code = "";
String ticket_name = "";
String type_money = "";
	Ticket t = (Ticket)session.getAttribute("ticket");
if(t != null) {
	ticket_code = t.getTicket_code();
	ticket_name = t.getTicket_name();
	type_money = t.getType_money1();
}
%>
   
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" href="style.css" />
<title>Tickets</title>
</head>
<body>
  <div class="main-box">
    <div class="side-menu">チケット登録</div>
    <section>
      <form action="<%=path %>" class="register-btn" method="get">
        <button class="button" type="submit" value="新規" >新規登録</button>
      </form>
      <table>
        <tr>
          <th>No</th><th>商品番号</th><th>チケット名</th><th>金額</th><th></th><th></th>
        </tr><tr>
          <td>1</td><td><%=ticket_code %></td><td><%=ticket_name %></td><td><%=type_money %></td><td></td><td></td>
        </tr><tr>
          <td>2</td><td></td><td></td><td></td><td></td><td></td>
        </tr><tr>
          <td>3</td><td></td><td></td><td></td><td></td><td></td>
        </tr><tr>
          <td>4</td><td></td><td></td><td></td><td></td><td></td>
        </tr><tr>
          <td>5</td><td></td><td></td><td></td><td></td><td></td>
        </tr>
      </table>
    </section>
  </div>
  

</body>
</html>