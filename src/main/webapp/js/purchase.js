const sumBox = document.getElementById("sum_price");
let priceBox = document.querySelectorAll('input[type="number"]');
const ticket_min_num = document.getElementById("ticket_min_num").value;
const ticket_max_num = document.getElementById("ticket_max_num").value;
const caution_min = document.getElementById("caution_min");
const caution_max = document.getElementById("caution_max");



priceBox.forEach(function(priceBox){
	priceBox.addEventListener('change', calSum);
})
function calSum() {
	let number = 0;
    let sumMoney = 0;
    let sumNumber = 0;
	priceBox.forEach(function(priceBox){
		number = parseInt(priceBox.value);
		if(priceBox.value.match(/^([1-9]\d*|0)$/) == null){
			number = 0;
		}
		let type_id = priceBox.id.substr(5);
		let type_money = parseInt(document.getElementById('price' + type_id).textContent);
		if(document.getElementById('price' + type_id).textContent.match(/^([1-9]\d*|0)$/) == null){
			type_money = 0;
		}
		sumMoney += number * type_money;
		sumNumber += number;
		
		
	})
	sumBox.innerHTML = sumMoney;

	if(sumNumber < ticket_min_num){
		caution_min.style.visibility = 'visible';
		
	}else{
		caution_min.style.visibility ='hidden';
		
	}
	if(sumNumber > ticket_max_num){
		caution_max.style.visibility ='visible';
	}else{
		caution_max.style.visibility ='hidden';
	}
    return sumNumber;	
}
function checkSum(){
	sumNumber = calSum();
	if(sumNumber < ticket_min_num){
		alert("チケット最小購入枚数を下回っています");
		return false;
	}
	if(sumNumber > ticket_max_num){
		alert("チケット最大購入枚数を上回っています");
		return false;
	}
	if(document.getElementById('price' + type_id).textContent.match(/^([1-9]\d*|0)$/) == null){
		alert("半角数字を入力してください");
		return false;
    }
	if(document.getElementById('price' + type_id).textContent.match(/^([1-9]\d*|0)$/) == null){
		alert("半角数字を入力してください");
		return false;
	}
		
	return true;
}