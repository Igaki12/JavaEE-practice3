<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.*" import="model.Ticket" import="model.DAO" import="java.util.List" import="model.Table1" import="model.Table7" import="model.PageProperty" import="model.Table5"%>
<%
   File fT = new File("/TicketServlet");
   String pTicket = fT.getName();
   File fN = new File("/NewAccount");
   String pNew = fN.getName();
   %>
   
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" href="style.css">
<script type="text/javascript" src="js/NewAccountCheck.js"></script>
<title>MakeANewAccount</title>
</head>
<body>
<div class="full-page-login">
  <h2>新アカウント作成</h2>
  <form class="list-parent" action="<%=pNew %>" method="post" id="login_form">
    <h3>ユーザー名</h3>
    <input type="text" name="login_id" id="login_id" placeholder="ユーザー名">
    <h3>パスワード</h3>
    <input type="text" name="password1" id="password1" placeholder="パスワード">
    <h3>パスワード(再入力)</h3>
    <input type="text" name="password2"  id="password2" placeholder="確認のためパスワードを再入力してください">
    <br>
    <br>
    <button class="button" type="submit" onclick="return check();">アカウント作成</button>
    <br>
  </form>
  　　
</div>
</body>
</html>