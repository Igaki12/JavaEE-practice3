<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.*" import="model.Table1" import="model.Table4" import="model.Table3" import="model.Table5" import="model.Table6" import="java.util.List"%>
<%File fr = new File("/RegisterServlet");
   String pRegister = fr.getName(); %>
<%File ft = new File("/TicketServlet");
   String pTicket = ft.getName(); 
   File fe = new File("/TicketEdit");
   String pEdit = ft.getName(); 
   String p = (String)request.getAttribute("page");
   Table1 t1 = (Table1)request.getAttribute("Table1");
   List<Table3> list3 = (List<Table3>)request.getAttribute("List3");
   List<Table4> list4 = (List<Table4>)request.getAttribute("List4");
   List<Table5> list5 = (List<Table5>)request.getAttribute("List5");
   Table6 t6 = (Table6)request.getAttribute("Table6");
   %>
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
  <form class="register-parent" action="<%=pEdit %>?Id=<%=t1.getId() %>&kind=1&page=<%=p %>" method="post" name="ticket_form">
    <h3>概要</h3>
    <h4>ジャンル大</h4>
    <label><input type="checkbox" name="genre_code1" class="checkbox" value="1"<%if(t1.getGenre_code1().equals("1")){ %>checked="checked"<%} %> >ジャンル大</label>
    <h4>ジャンル小</h4>
    <label><input type="checkbox" name="genre_code2" class="checkbox" value="1"<%if(t1.getGenre_code2().equals("1")){ %>checked="checked"<%} %>>ジャンル小</label><br>
    <div class="register-flex"><div>チケット名</div><input type="text" name="ticket_name" value="<%=t1.getTicket_name()%>"><p>※必須</p></div>
    <div class="register-flex"><div>概要</div><input type="text" name="contents_data1" value="<%=list3.get(0).getContents_data()%>"></div>
    <div class="register-flex"><div>画像</div><input type="file" name=""></div>
    <br>
    <h3>詳細</h3>
    <div class="register-flex"><div>紹介</div><input type="file" name=""></div>
    <div class="register-flex"><div>重要注意事項</div><input type="text" name="cautions_text1" value="<%=list4.get(0).getCautions_text()%>"></div>
    <div class="register-flex"><div>チケット紹介</div><input type="text" name="contents_data2" value="<%=list3.get(1).getContents_data()%>"></div>
    <div class="register-flex"><div>紹介画像</div><input type="file" name=""></div>
    <div class="register-flex"><div>注意事項</div><input type="text" name="cautions_text2" value="<%=list4.get(1).getCautions_text()%>"></div>
    <div class="register-flex"><div>お問合せ</div><input type="text" name="ticket_remarks" value="<%=t1.getTicket_remarks()%>"></div>
    <br>
    <h3>商品設定</h3>
    <div class="register-flex"><div>商品番号</div><input type="text" name="ticket_code" value="<%=t1.getTicket_code() %>"><p>※必須</p></div>
    <div class="register-flex"><div>確認オプション</div><label><input type="checkbox" class="checkbox" name="minors_flag" value="1" <%if(t1.getMinors_flag() == 1){ %>checked="checked"<%} %>>未成年フラグ</label></div>
    <div class="register-flex"><div>キャンセル料発生期限(分)</div><input type="number" name="cancel_limit" value="<%=t1.getCancel_limit() %>"><p>※必須</p></div>
    <div class="register-flex"><h4>料金</h4><p>※必須</p></div>
    <div class="register-grid" id="grid">
      <%for(int i=0;i<list5.size();i++){
    	  Table5 t5 = list5.get(i);
    	  %>
      
      <div>名称<%=i+1%></div><div>単価<%=i+1%></div><div>キャンセル料<%=i+1%></div>
      <input type="text" name="type_name<%=i+1%>" value="<%=t5.getType_name()%>"><input type="number" name="type_money<%=i+1%>" min="0" step="10"value="<%=t5.getType_money()%>"><input type="number" name="cancel_rate<%=i+1%>" id="cancel_rate<%=i+1%>" min="0" step="10" value="<%=t5.getCancel_rate()%>">
      <%} %>
      <button class="button" type="button" id="addButton" onclick="return add();">↓追加</button>
      <div></div>
      <button class="button" type="button" id="deleteButton" onclick="return deleteElements();">↑削除</button>
    </div>
    
    <br>
    <div class="register-flex"><div>注意事項</div><input type="text" name="cautions_text3" value="<%=list4.get(2).getCautions_text()%>"></div>
    <h3>チケット設定</h3>
    <div class="register-flex"><label><input type="radio" name="tickets_kind" class="radio" value="1"<%if(t1.getTickets_kind() == 1){ %>checked="checked"<%} %>>フリーチケット</label><label><input type="radio" name="tickets_kind" class="radio" value="2"<%if(t1.getTickets_kind() == 2){ %>checked="checked"<%} %>>指定チケット</label></div>
    <br>
    <h3>サービス設定</h3>
    <div class="register-flex"><div>サービス名</div><input type="text" name="svc_name" value="<%=t6.getSvc_name()%>"><p>※必須</p></div>
    <div class="register-flex"><div>内容・注意事項</div><input type="text" name="svc_cautions" value="<%=t6.getSvc_cautions()%>"><p>※必須</p></div>
    <div class="register-flex"><div>サービス種類</div><input type="file" name=""></div>
    <div class="register-flex"><label><input type="radio" name="svc_select_type" class="radio" value="1"<%if(t6.getSvc_select_type() == 1){ %>checked="checked"<%} %>>サービス１</label><label><input type="radio" name="svc_select_type" class="radio" value="2" <%if(t6.getSvc_select_type() == 2){ %>checked="checked"<%} %>>サービス２</label></div>
    <br>
    <div class="register-button-flex">
      <button class="button" type="submit" name="submit-btn" onclick="return check();">更新する</button>
      <button class="button" type="button" name="return-btn" onclick="location.href='<%=pTicket %>?kind=1&page=<%=p %>'">戻る</button>
      
    </div>
    
  </form>
  
  

</div>

</body>
</html>