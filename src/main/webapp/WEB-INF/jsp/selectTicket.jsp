<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.io.*"%>
<%File fd = new File("/DateServlet");
   String pRegisterDate = fd.getName(); %>
<%File ft = new File("/TicketServlet");
   String pTicket = ft.getName(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>Register</title>
</head>
<body>
<div class="full-page-mini">
  <form class="register-parent" action="<%=pRegisterDate %>" method="post" name="ticket_form">
    <h3>商品番号</h3>
      <select name="ticket_code" class="select-box">
        <option hidden>5つの選択肢を表示</option>
        <option value="選択肢2">選択肢2</option>
        <option value="選択肢3">選択肢3</option>
        <option value="選択肢4">選択肢4</option>
        <option value="選択肢5">選択肢5</option>
        <option value="選択肢6">選択肢6</option>
        <option value="選択肢7">選択肢7</option>
      </select>

    <div class="register-button-flex">
      <button type="submit" class="button" onclick="">選択する</button>
      <button type="button" class="button" onclick="location.href='<%=pTicket %>'">戻る</button>
    </div>
  </form>
</div>

</body>
</html>