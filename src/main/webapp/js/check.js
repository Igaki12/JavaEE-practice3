function check() {
	let formElements = document.forms.ticket_form;
	let fault_flag = 0;
	let alertMsg = "";
	
	if(formElements.ticket_name.value == ""){
		alertMsg += "チケット名を入力してください\n";
		fault_flag += 1;
	}
	if(formElements.ticket_code.value == ""){
		alertMsg += "商品番号を入力してください\n";
		fault_flag += 1;
	}
	if(formElements.cancel_limit.value == ""){
		alertMsg += "キャンセル料発生期限（分）を入力してください\n";
		fault_flag += 1;
	}
	if(formElements.type_name1.value == ""){
		alertMsg += "料金名称を入力してください\n";
		fault_flag += 1;
	}if(formElements.type_money1.value == ""){
		alertMsg += "料金単価を入力してください\n";
		fault_flag += 1;
	}if(formElements.type_money1.value % 10 != 0){
		alertMsg += "料金単価は１０の倍数で入力してください\n";
		fault_flag += 1;
	}
	if(formElements.cancel_rate1.value == ""){
		alertMsg += "キャンセル料を入力してください\n";
		fault_flag += 1;
	}if(formElements.cancel_rate1.value % 10 != 0){
		alertMsg += "キャンセル料は１０の倍数で入力してください\n";
		fault_flag += 1;
	}if(formElements.svc_name.value == ""){
		alertMsg += "サービス名を入力してください\n";
		fault_flag += 1;
	}if(formElements.svc_cautions.value == ""){
		alertMsg += "サービス注意事項を入力してください\n";
		fault_flag += 1;
	}	
	if(alertMsg != ""){
		alert(alertMsg);
	}	
	if(fault_flag == 0){
		return true;
	}
	else {
		return false;
	}
}

	let boxNumber = 3;
function add(){

	let addButton = document.getElementById("addButton");
	
	let h = '<div>名称'+boxNumber+'</div><div>単価'+boxNumber+'</div><div>キャンセル料'+boxNumber+'</div><input type="text" name="type_name'+boxNumber+'"><input type="number" name="type_money'+boxNumber+'" min="0" step="10"><input type="number" name="cancel_rate'+boxNumber+'" min="0" step="10" id="cancel_rate'+boxNumber+'">'
	
	addButton.insertAdjacentHTML('beforebegin',h);
	boxNumber = boxNumber + 1;
	
	return true;
} 