<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.io.*" import="java.util.*" import="model.Table1"%>
<%File fd = new File("/RegisterDate");
   String pRegisterDate = fd.getName(); %>
<%File ft = new File("/TicketServlet");
   String pTicket = ft.getName(); %>
<%List<Table1> list = (List<Table1>)request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<script type="text/javascript" src="js/DateCheck.js"></script>
<title>Register</title>
</head>
<body>
<div class="full-page">
<br>
  <form class="register-parent" action="<%=pRegisterDate %>" method="post" name="ticket_form">
    <h3>商品番号</h3>
    <br>
      <select name="ticket_code" class="select_box">
        <option hidden>商品番号を選択</option>
        <%for(Table1 t1 : list) {
        	String ticket_code = t1.getTicket_code();
        	int id = t1.getId();
        	%>
        <option value="<%=id %>"><%=ticket_code %></option>
        <%} %>
      </select>

    <div class="register-button-flex">
      <button type="submit" class="button" onclick="return checkSelectBox();">選択する</button>
      <button type="button" class="button" onclick="location.href='<%=pTicket %>'">戻る</button>
    </div>
  </form>
</div>

</body>
</html>