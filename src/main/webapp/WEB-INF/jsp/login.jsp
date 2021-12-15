<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.*" import="model.Ticket" import="model.DAO" import="java.util.List" import="model.Table1" import="model.Table7" import="model.PageProperty" import="model.Table5"%>
<%
   File fT = new File("/TicketServlet");
   String pTicket = fT.getName();
   File fL = new File("/LoginServlet");
   String pLogin = fL.getName();
   %>
   
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" href="style.css">
<script type="text/javascript" src="js/login.js"></script>
<title>Login</title>
</head>
<body>
<div class="full-page-login">
  <h2>ログイン画面</h2>
  <form class="list-parent" action="<%=pLogin %>" method="post" id="login_form">
    <h3>ユーザーID</h3>
    <input type="text" name="login_id" placeholder="ユーザー名">
    <h3>パスワード</h3>
    <input type="password" name="password" placeholder="パスワード" id="pass">
    <button class="button" type="button" onclick="displayPass();" id="displayBtn"> 表示 </button><br>
    <br>
    <br>
    <button class="button" type="submit" >ログイン</button>
    <br>
  </form>
  　　
</div>
</body>
</html>