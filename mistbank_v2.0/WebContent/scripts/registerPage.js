// Wait for the DOM to be ready
$(function () {
  // Initialize form validation on the registration form.
  // It has the name attribute "registration"
  $("form[name='registration']").validate({
    // Specify validation rules
    rules: {
      // The key name on the left side is the name attribute
      // of an input field. Validation rules are defined
      // on the right side
      username: {
        required: true
      },

      psw: {
        required: true,
        minlength: 5,
        pattern: /^[a-zA-Z0-9]{5,25}$/ // minimum 5 length
      },

      psw_repeat: {
        required: true,
        equalTo: "#psw"

      },
      fname: {
        required: true,
        pattern: /^[a-zA-Z]{2,25}$/


      },
      lname: {
        required: true,
        pattern: /^[a-zA-Z]{2,25}$/
      },
      ssn: {
        required: true,
        pattern: /^[0-9]{9,9}$/
      },

      phno: {
        required: true,
        pattern: /^[0-9]{10,10}$/
      }
      //      ssn: {
      //    	  required: true,
      //    	  pattern: /^[0-9]{9}$/
      //      }

    },
    // Specify validation error messages

    messages: {

      fname: "Please enter your firstname",
      lname: "Please enter your lastname",
      psw: {
        required: "Please provide a password",
        minlength: "Your password must be at least 5 characters long"
      },
      psw_repeat: {
        required: "Please confirm the password",
        equalTo: "Passwords do not match"
      },
      ssn: "SSN should be 9 digits only no dash and spaces",

      phno: "Phone number should be 10 digits number ONLY"
    },
    // Make sure the form is submitted to the destination defined
    // in the "action" attribute of the form when valid
    submitHandler: function (form) {
      form.submit();
    }
  });

  //$('input[name="phno"]').mask('(000) 000 0000');
  //$('input[name="ssn"]').mask('000-00-0000');

});


async function loginuser() {
  event.preventDefault();
  var user = document.getElementsByName("username")[0].value;
  var pass = document.getElementsByName("psw")[0].value;

  const url = 'http://localhost:1238/mistbank_v2.0/login';
  const data = { username: user, userpassword: pass };
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
            if(data.username!=""){ 
              console.log("End of if statement"+data.username);
                window.location.href = "http://localhost:1238/mistbank_v2.0/account.html";
                localStorage.setItem('username', data.username);
                
               
            } else {
                document.getElementById("invalidBox").innerText = "Invlaid email or password"
            }

        })
     
  return false;
}

function getUser(){
	//alert("called "+localStorage.getItem('username'));
	 document.getElementsByName("username")[0].innerText = localStorage.getItem('username');
	 document.getElementById('navbarDropdownMenuLink').innerText=localStorage.getItem('username');
}
