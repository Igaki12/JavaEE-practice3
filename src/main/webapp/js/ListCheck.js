let buttonOpen = document.querySelectorAll('input[class="button"]');
let buttonClose = document.querySelectorAll('span[class="modalClose"]');
let openedListIndex = "0";

buttonOpen.forEach(function(buttonOpen){
	buttonOpen.addEventListener('click', modalOpen);
})
function modalOpen() {
	let row = this.name.substr(10);
	openedListIndex = row;
	let modal = document.getElementById("modal" + row);
  modal.style.display = "block";
}

buttonClose.forEach(function(buttonClose){
	buttonClose.addEventListener('click', modalClose);
})
function modalClose(){
	let row = this.id.substr(10);
	let modal = document.getElementById("modal" + row);
	modal.style.display = "none";
}

//まだ未完成部分
addEventListener('click', outsideClose);
let modal = document.getElementById("modal" + opendListIndex);
function outsideClose(e){
	let modal = document.getElementById("modal" + openedListIndex);
	if(e.target == modal){
		modal.style.display = "none";
	}
}