<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.*" %>
<%File fr = new File("/RegisterServlet");
   String pathR = fr.getName(); %>
<%File ft = new File("/TicketServlet");
   String pathT = ft.getName(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>Register</title>
</head>
<body>
  <div class="full-page">
  <h2>新規登録</h2>
  <form class="register-parent" action="<%=pathT %>" method="post">
    <h3>概要</h3>
    <h4>ジャンル大</h4>
    <input type="checkbox" name="genreB" class="checkbox">ジャンル大
    <h4>ジャンル小</h4>
    <input type="checkbox" name="genreS" class="checkbox">ジャンル小<br>
    <div class="register-flex"><div>チケット名</div><input type="text" name="ticket_name"></div>
    <div class="register-flex"><div>概要</div><input type="text" name="outline"></div>
    <div class="register-flex"><div>画像</div><input type="file" name="img"></div>
    <br>
    <h3>詳細</h3>
    <div class="register-flex"><div>紹介</div><input type="file" name="contents"></div>
    <div class="register-flex"><div>重要注意事項</div><input type="text" name="mostCaution"></div>
    <div class="register-flex"><div>チケット紹介</div><input type="text" name="contents_data"></div>
    <div class="register-flex"><div>紹介画像</div><input type="file" name="contentsImg"></div>
    <div class="register-flex"><div>注意事項</div><input type="text" name="caution"></div>
    <div class="register-flex"><div>お問合せ</div><input type="text" name="inquiry"></div>
    <br>
    <h3>商品設定</h3>
    <div class="register-flex"><div>商品番号</div><input type="file" name="ticket_code"></div>
    <div class="register-flex"><div>確認オプション</div><input type="checkbox" class="checkbox">未成年フラグ</div>
    <div class="register-flex"><div>キャンセル料発生期限(分)</div><input type="file" name="cancel_limit_start_min"></div>
    <h4>料金</h4>
    <div class="register-grid">
      <div>名称１</div><div>単価１</div><div>キャンセル料１</div>
      <input type="text" name="type_name1"><input type="number" name="type_money1" min="0" step="100"><input type="number" name="cancel_money1">
      <div>名称２</div><div>単価２</div><div>キャンセル料２</div>
      <input type="text" name="type_name2"><input type="number" name="type_money2"><input type="number" name="cancel_money2">
    </div>
    <div class="register-flex"><div>注意事項</div><input type="text" name="caution2"></div>
    <br>
    <h3>チケット設定</h3>
    <div class="register-flex"><input type="radio" name="reserved" class="radio" value="0">フリーチケット<input type="radio" name="reserved" class="radio" value="1">指定チケット</div>
    <br>
    <h3>サービス設定</h3>
    <div class="register-flex"><div>サービス名</div><input type="text" name="serviceName"></div>
    <div class="register-flex"><div>内容・注意事項</div><input type="text" name="serviceContents"></div>
    <div class="register-flex"><div>サービス種類</div><input type="file" name=""></div>
    <div class="register-flex"><input type="radio" name="" class="radio">サービス１<input type="radio" name="" class="radio">サービス２</div>
    <br>
    <div class="register-button-flex">
      <button class="button" type="submit" name="submit-btn" method="post">登録する</button>
      <button class="button" type="button" name="return-btn" onclick="location.href='<%=pathT %>'">戻る</button>
    </div>
    
  </form>
  

</div>
</body>
</html>