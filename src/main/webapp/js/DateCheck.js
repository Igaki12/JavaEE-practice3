function checkSelectBox(){
	let selectBox = document.getElementsByTagName("select").item(0);
	let index = selectBox.options.selectedIndex;
	let selectedValue = selectBox.options[index].value;
	if (selectedValue == ""){
		alert("Select the box.");
		return false;
	}else if(selectedValue == "商品番号を選択"){
		alert("Select the box.");
		return false;
	}else {
		return true;
	}
	
}

function checkDate1() {
	let FormElements = document.forms.form;
	let alertMsg = "";
	let flag = 0;
	
	if(FormElements.sales_interval_startDay.value.match(/^\d{4}-\d\d-\d\d$/) == null){
		alertMsg += "販売日付（開始）を入力してください（yyyy-MM-dd）\n";
		flag += 1;
	}if(FormElements.sales_interval_endDay.value.match(/^\d{4}-\d\d-\d\d$/) == null){
		alertMsg += "販売日付（終了）を入力してください（yyyy-MM-dd）\n";
		flag += 1;
	}if(FormElements.ticket_interval_start.value.match(/^\d{4}-\d\d-\d\d$/) == null){
		alertMsg += "有効期限（開始）を入力してください（yyyy-MM-dd）\n";
		flag += 1;
	}if(FormElements.ticket_interval_end.value.match(/^\d{4}-\d\d-\d\d$/) == null){
		alertMsg += "有効期限（終了）を入力してください（yyyy-MM-dd）\n";
		flag += 1;
	}
	if(FormElements.sales_interval_startTime.value.match(/^\d\d:\d\d$/) == null){
		alertMsg += "販売時間（開始）を入力してください（hh:mm）\n";
		flag += 1;
	}if(FormElements.sales_interval_endTime.value.match(/^\d\d:\d\d$/) == null){
		alertMsg += "販売時間（終了）を入力してください（hh:mm）\n";
		flag += 1;
	}
	if(FormElements.ticket_num.value.match(/^([1-9]\d*)$/) == null){
		alertMsg += "販売枚数を入力してください（自然数）\n";
		flag += 1;
	}if(FormElements.ticket_min_num.value.match(/^([1-9]\d*)$/) == null){
		alertMsg += "1枚あたりの最小枚数を入力してください（自然数）\n";
		flag += 1;
	}if(FormElements.ticket_max_num.value.match(/^([1-9]\d*)$/) == null){
		alertMsg += "1枚あたりの最大枚数を入力してください（自然数）\n";
		flag += 1;
	}
	if(FormElements.ticket_min_num.value.match(/^([1-9]\d*)$/) != null && FormElements.ticket_max_num.value.match(/^([1-9]\d*)$/) != null){
		if(FormElements.ticket_min_num.value > FormElements.ticket_max_num.value){
		alertMsg += "1枚あたりの最大枚数が最小枚数より小さくなっています\n";
		flag += 1;
	    }
	}
	
	
	if(alertMsg != ""){
		alert(alertMsg);
	}
	if(flag > 0){
		return false;
	}else{
		return true;
	}
}