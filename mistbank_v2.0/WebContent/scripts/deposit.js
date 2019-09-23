function getBalance(){
	event.preventDefault();

	  const url = 'http://localhost:1238/mistbank_v2.0/balance?username='+localStorage.getItem('username');

	  console.log("before fetch");
	  fetch(url, {
	            method: 'GET',
	          
	        })
	        .then(res => {
	            return res.json();
	        }).then(data => {
	            pageData = data;
	            console.log(pageData);
	            //console.log("End of if statement"+pageData.username);
	            if(data!=""){ 
	            	document.getElementById("balance").innerText =" Your balance is: $ "+ data;
	               
	            } else {
	                document.getElementById("invalidBox").innerText = "Invlaid balance"
	            }

	        })
	     
	  return false;
}