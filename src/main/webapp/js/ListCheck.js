let buttonOpen = document.querySelectorAll('input[class="button"]');
let buttonClose = document.querySelectorAll('span[class="modalClose"]');

buttonOpen.forEach(function(buttonOpen){
	buttonOpen.addEventListener('click', modalOpen);
})
function modalOpen() {
	let row = this.name.substr(10);
	let modal = document.getElementById("modal" + row);
  modal.style.display = "block";
}

buttonClose.forEach(function(buttonClose){
	buttonClose.addEventListener('click', modalClose);
})
function modalClose(){
	let row = this.name.substr(9);
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