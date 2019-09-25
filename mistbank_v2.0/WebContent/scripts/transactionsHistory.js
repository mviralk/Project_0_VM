function getTransactions(){
	event.preventDefault();
		
	  const url = 'http://localhost:1238/mistbank_v2.0/transaction?username='+localStorage.getItem('username');

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
	            	let results = "<table border = '1px' class = 'table' > <thead class='thead-dark'> <tr> <th scope='col'>Transaction ID</th> <th scope='col'>Account Number</th> <th scope='col'> Withdraw </th> <th scope='col'> Deposit </th>  <th scope='col'> Transaction Date </th> </tr> </thead> ";
	            	 data.forEach(res => {
	            		 results = results+"<tbody>";
	            		 results = results+"<tr>";
		            		results = results+"<td>"+res.transactionId+"</td>";
		            		results = results+"<td>"+res.checkingaccountnumber+"</td>";
		            		results = results+"<td>"+res.withdraw+"</td>";
		            		results = results+"<td>"+res.deposit+"</td>";
		            		results = results+"<td>"+res.transactionDate+"</td>";
		            		results = results+"</tr>";
		            		results = results+"</tbody>";
	                 });
	            	 results = results+"</table>";
	            	document.getElementById("transactions").innerHTML = results;
	               
	            } else {
	                document.getElementById("invalidBox").innerText = "Invlaid balance"
	            }

	        })
	     
	  return false;
}