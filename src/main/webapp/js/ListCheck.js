let buttonOpen = document.querySelectorAll('input[class="button"]');
let modal = document.querySelectorAll("div[class='easyModal']");
let buttonClose = document.querySelectorAll("span[class='modalClose']");
alert(buttonOpen);
alert(buttonClose);
alert(modal);

buttonOpen.forEach(function(buttonOpen){
	buttonOpen.addEventListener('click', modalOpen);
	let row = this.name.substr(10);
	alert(row);
})
function modalOpen() {
	let row = this.name.substr(10);
	let modal = document.getElementById("modal" + row);
  modal.style.display = "block";
}

buttonClose.forEach(function(buttonClose){
	buttonClose.addEventListener('click', modalClose);
	let row = this.id.substr(9);
	alert(row);
})
function modalClose(){
	let modal = document.getElementById("modal" + row);
	modal.style.display = "none";
}

//まだ未完成部分
addEventListener('click', outsideClose);
function outsideClose(e){
	if(e.target == modal){
		
		let modal = document.getElementById("modal" + row);
		modal.style.display = "none";
	}
}