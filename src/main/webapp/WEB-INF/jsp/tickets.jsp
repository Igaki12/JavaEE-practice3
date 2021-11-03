<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.*" %>
<%File f = new File("/RegisterServlet");
   String path = f.getName(); %>
   
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
          <th>No</th><th>商品番号</th><th>チケット番号</th><th>金額</th><th></th><th></th>
        </tr><tr>
          <td>1</td><td></td><td></td><td></td><td></td><td></td>
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