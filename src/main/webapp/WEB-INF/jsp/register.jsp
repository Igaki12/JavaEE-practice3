<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.*" %>
<%File fr = new File("/RegisterServlet");
   String pRegister = fr.getName(); %>
<%File ft = new File("/TicketServlet");
   String pTicket = ft.getName(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<script type="text/javascript" src="js/check.js"></script>
<title>Register</title>
</head>
<body>
  <div class="full-page">
  <h2>新規登録</h2>
  <form class="register-parent" action="<%=pRegister %>" method="post" name="ticket_form">
    <h3>概要</h3>
    <h4>ジャンル大</h4>
    <label><input type="checkbox" name="genre_code1" class="checkbox" value="1">ジャンル大</label>
    <h4>ジャンル小</h4>
    <label><input type="checkbox" name="genre_code2" class="checkbox" value="1">ジャンル小</label><br>
    <div class="register-flex"><div>チケット名</div><input type="text" name="ticket_name"></div>
    <div class="register-flex"><div>概要</div><input type="text" name="contents_data1"></div>
    <div class="register-flex"><div>画像</div><input type="file" name=""></div>
    <br>
    <h3>詳細</h3>
    <div class="register-flex"><div>紹介</div><input type="file" name=""></div>
    <div class="register-flex"><div>重要注意事項</div><input type="text" name="cautions_text1"></div>
    <div class="register-flex"><div>チケット紹介</div><input type="text" name="contents_data2"></div>
    <div class="register-flex"><div>紹介画像</div><input type="file" name=""></div>
    <div class="register-flex"><div>注意事項</div><input type="text" name="cautions_text2"></div>
    <div class="register-flex"><div>お問合せ</div><input type="text" name="ticket_remarks"></div>
    <br>
    <h3>商品設定</h3>
    <div class="register-flex"><div>商品番号</div><input type="text" name="ticket_code"></div>
    <div class="register-flex"><div>確認オプション</div><label><input type="checkbox" class="checkbox" name="minors_flag" value="1">未成年フラグ</label></div>
    <div class="register-flex"><div>キャンセル料発生期限(分)</div><input type="number" name="cancel_limit"></div>
    <h4>料金</h4>
    <div class="register-grid" id="grid">
      <div>名称1</div><div>単価1</div><div>キャンセル料1</div>
      <input type="text" name="type_name1"><input type="number" name="type_money1" min="0" step="10"><input type="number" name="cancel_rate1"min="0" step="10">
      <div class="type2">名称2</div><div class="type2">単価2</div><div class="type2">キャンセル料2</div>
      <input type="text" name="type_name2"><input type="number" name="type_money2" min="0" step="10"><input type="number" name="cancel_rate2" min="0" step="10" id="cancel_rate2">
      <button class="button" type="button" id="addButton" onclick="return add();">↓追加</button>
      <div></div>
      <button class="button" type="button" id="deleteButton" onclick="return deleteElements();">↑削除</button>
    </div>
    
    <br>
    <div class="register-flex"><div>注意事項</div><input type="text" name="cautions_text3"></div>
    <h3>チケット設定</h3>
    <div class="register-flex"><label><input type="radio" name="tickets_kind" class="radio" value="1">フリーチケット</label><label><input type="radio" name="tickets_kind" class="radio" value="2">指定チケット</label></div>
    <br>
    <h3>サービス設定</h3>
    <div class="register-flex"><div>サービス名</div><input type="text" name="svc_name"></div>
    <div class="register-flex"><div>内容・注意事項</div><input type="text" name="svc_cautions"></div>
    <div class="register-flex"><div>サービス種類</div><input type="file" name=""></div>
    <div class="register-flex"><label><input type="radio" name="svc_select_type" class="radio" value="1">サービス１</label><label><input type="radio" name="svc_select_type" class="radio" value="2">サービス２</label></div>
    <br>
    <div class="register-button-flex">
      <button class="button" type="submit" name="submit-btn" onclick="return check();">登録する</button>
      <button class="button" type="button" name="return-btn" onclick="location.href='<%=pTicket %>'">戻る</button>
      
    </div>
    
  </form>
  
  

</div>

</body>
</html>