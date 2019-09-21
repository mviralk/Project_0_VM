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
    	  pattern: /^[0-9]{9}$/
      },
      
      phno: {
    	  required: true,
    	  pattern: /^[0-9]{10}$/
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