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
	if(formElements.cancel_limit.value.match(/^([1-9]\d*)$/) == null){
		alertMsg += "キャンセル料発生期限（分）を自然数で入力してください\n";
		fault_flag += 1;
	}
	if(formElements.type_name1.value == ""){
		alertMsg += "料金名称を入力してください\n";
		fault_flag += 1;
	}if(formElements.type_money1.value.match(/^([1-9]\d*[0])$/) == null){
		alertMsg += "料金単価を10の倍数で入力してください\n";
		fault_flag += 1;
	}
	if(formElements.cancel_rate1.value.match(/^([1-9]\d*[0])$/) == null){
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

	let boxNumber = 2;
function add(){
	boxNumber = boxNumber + 1;
	let addButton = document.getElementById("addButton");
	
	let h = '<div class="type' + boxNumber + '">名称'+boxNumber+'</div><div class="type' + boxNumber + '">単価'+boxNumber+'</div><div class="type' + boxNumber + '">キャンセル料'+boxNumber+'</div><input type="text" name="type_name'+boxNumber+'"><input type="number" name="type_money'+boxNumber+'" min="0" step="10"><input type="number" name="cancel_rate'+boxNumber+'" min="0" step="10" id="cancel_rate'+boxNumber+'">'
	
	addButton.insertAdjacentHTML('beforebegin',h);

	return true;
} 
function deleteElements() {
	
	if(boxNumber < 2 ){
		return;
	}
	let latestLabels = document.getElementsByClassName('type' + boxNumber);
	latestLabels.item(0).remove();
	latestLabels.item(0).remove();
	latestLabels.item(0).remove();
	let latestTypeName = document.getElementsByName('type_name'+ boxNumber);
	latestTypeName.item(0).remove();
	let latestTypeMoney = document.getElementsByName('type_money'+ boxNumber);
	latestTypeMoney.item(0).remove();
	let latestCancelRate = document.getElementsByName('cancel_rate'+ boxNumber);
	latestCancelRate.item(0).remove();

	
		boxNumber -= 1;
		alert(boxNumber);
	
}

