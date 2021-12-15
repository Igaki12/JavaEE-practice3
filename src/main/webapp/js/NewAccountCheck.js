function check(){
	let login_id = document.getElementById("login_id").value;
	let password1 = document.getElementById("password1").value;
	let password2 = document.getElementById("password2").value;
	let alertMsg = "";
	let flag = 0;
	
	if(login_id == null || login_id == ""){
		alertMsg += "ユーザーIDを入力してください \n";
		flag = 1;
	}
	if(password1 != password2){
		alertMsg += "パスワードが一致しません。\n"
		flag = 1;
	}
	
	if(flag != 0){
		alert(alertMsg);
		return false;
	}
	return true;
}