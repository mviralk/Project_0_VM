async function userdeposit() {
	  event.preventDefault();
	  var bal = document.getElementById("depositamount").value;
	  console.log(bal);
	  const url = 'http://localhost:1238/mistbank_v2.0/transaction';
	  const data = { deposit: bal };
	  console.log(data);
	  console.log("before fetch");
	  fetch(url, {
	            method: 'POST',
	            body: JSON.stringify(data)
	        })
	        .then(res => {
	            return res.json();
	        }).then(data => {
	            pageData = data;
	            console.log(pageData);
	            //console.log("End of if statement"+pageData.username);
	            if(data.deposit!=""){ 
	              console.log("End of if statement"+data.desposit);
	                window.location.href = "http://localhost:1238/mistbank_v2.0/deposit.html";
	                localStorage.setItem('depositamount', data.deposit);
	                
	               
	            } else {
	                document.getElementById("invalidBox").innerText = "Invlaid email or password"
	            }

	        })
	     
	  return false;
}


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

