function displayPass(){
	const pass = document.getElementById("pass");
	const Btn = document.getElementById("displayBtn");
	console.log(Btn);
	if(pass.type == "password"){
		console.log("A route");
		pass.type = "text";
		Btn.textContent = "非表示";
	}else if(pass.type == "text"){
		console.log("B route");
		pass.type = "password";
		Btn.textContent = " 表示 ";
	}
}