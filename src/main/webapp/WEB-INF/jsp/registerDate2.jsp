<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.io.*" import="java.util.*" import="model.Table1" import="model.Table6" %>
<%
File fr = new File("/RegisterDate");
String pRegisterD = fr.getName();
File ft = new File("/TicketServlet");
String pTicket = ft.getName();

Table1 t1 = (Table1)request.getAttribute("Table1");
Table6 t6 = (Table6)request.getAttribute("Table6");
String tickets_kind = null;
if(t1.getTickets_kind() == 1){
	tickets_kind = "フリーチケット";
}if(t1.getTickets_kind() == 2){
	tickets_kind = "指定チケット";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>Register Date forDesignatedTicket</title>
</head>
<body>
  <div class="full-page">
    <h2>指定チケット登録</h2>
    <form class="registerDate-parent" action="<%=pTicket %>?kind=2" method="post">
        <div class="register-flex"><h4>商品番号</h4><p><%=t1.getTicket_code() %></p></div>
        <div class="register-flex"><h4>チケット販売種類</h4><p><%=tickets_kind %></p></div>
        <div class="register-flex"><h4>サービス</h4><p><%=t6.getSvc_name() %></p></div>
        <br>
        <h3>販売期間</h3>
        <div class="registerDate-grid">
          <h4>販売日付（開始）</h4><h4>販売時間（開始）</h4><h4>販売日付（終了）</h4><h4>販売時間（終了）</h4>
          <input type="date" min="2010-01-01" max="2029-12-31" name="sales_interval_startDay"></input><input type="time" name="sales_interval_startTime"></input>
          <input type="date" min="2010-01-01" max="2029-12-31" name="sales_interval_endDay"></input><input type="time" name="sales_interval_endTime"></input>
          <h4>有効期限</h4><h4></h4><div></div><div></div>
          <input type="number" min="0" name="ticket_days"><div></div><div></div>
        </div>
        <br>
        <h3>予約日</h3>
        <div class="registerDate-grid">
          <div><h4>利用可能日</h4></div><div><h4>販売枚数</h4></div><h4>1枚あたりの最小枚数</h4><h4>1枚あたりの最大枚数</h4>
          <input type="date" min="2010-01-01" max="2029-12-31" name="ticket_interval_startDay"><input type="number" min="0" name="ticket_num"><input type="number" min="0" name="ticket_min_num"><input type="number" min="0" name="ticket_max_num">
        </div>
          
        
        
        <div class="register-button-flex">
          <button type="submit" class="button" onclick="return">登録する</button>
          <button type="button" class="button" onclick="location.href='<%=pRegisterD %>'">戻る</button>
        </div>
    </form>

  </div>
</body>
</html>