const sumBox = document.getElementById("sum_price");
let priceBox = document.querySelectorAll('input[type="number"]');
let number = 0;
let sumMoney = 0;
let sumNumber = 0;


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
			alert("半角数字を入力してください");
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
}