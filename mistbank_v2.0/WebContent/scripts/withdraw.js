async function userwithdraw() {
	  event.preventDefault();
	  var bal = document.getElementById("withdrawamount").value;
	  console.log(bal);
	  const url = 'http://localhost:1238/mistbank_v2.0/transaction';
	  const data = { withdraw: bal };
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
	            if(data.withdraw!=""){ 
	              console.log("End of if statement"+data.withdraw);
	                window.location.href = "http://localhost:1238/mistbank_v2.0/withdraw.html";
	                localStorage.setItem('withdrawamount', data.withdraw);
	                
	               
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
	            	document.getElementById("balance").innerText =" Your new balance is: $ "+ data;
	               
	            } else {
	                document.getElementById("invalidBox").innerText = "Invlaid balance"
	            }

	        })
	     
	  return false;
}

