"use strict";

//Plaeholder handler
$(function() {
	
if(!Modernizr.input.placeholder){             //placeholder for old brousers and IE
 
  $('[placeholder]').focus(function() {
   var input = $(this);
   if (input.val() == input.attr('placeholder')) {
    input.val('');
    input.removeClass('placeholder');
   }
  }).blur(function() {
   var input = $(this);
   if (input.val() == '' || input.val() == input.attr('placeholder')) {
    input.addClass('placeholder');
    input.val(input.attr('placeholder'));
   }
  }).blur();
  $('[placeholder]').parents('form').submit(function() {
   $(this).find('[placeholder]').each(function() {
    var input = $(this);
    if (input.val() == input.attr('placeholder')) {
     input.val('');
    }
   })
  });
 }
  
$('#contact-form').submit(function(e) {
      
		e.preventDefault();	
		var error = 0;
		var self = $(this);
		
	    var $name = self.find('[name=user-name]');
	    var $email = self.find('[type=email]');
	    var $message = self.find('[name=user-message]');

		
				
		var emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
		
  		if(!emailRegex.test($email.val())) {
			createErrTult('Error! Wrong email!', $email)
			error++;	
		}
		if( $name.val().length>1 &&  $name.val()!= $name.attr('placeholder')  ) {
			$name.removeClass('invalid_field');			
		} 
		else {
			createErrTult('Error! Write your name!', $name)
			error++;
		}

		if($message.val().length>2 && $message.val()!= $message.attr('placeholder')) {
			$message.removeClass('invalid_field');
		} 
		else {
			createErrTult('Error! Write message!', $message)
			error++;
		}
		
		
		
		if (error!=0)return;
		self.find('[type=submit]').attr('disabled', 'disabled');

		self.children().fadeOut(300,function(){ $(this).remove() })
		$('<p class="success"><span class="success-huge">Thank you!</span> <br> your message successfully sent</p>').appendTo(self)
		.hide().delay(300).fadeIn();


		var formInput = self.serialize();
		$.post(self.attr('action'),formInput, function(data){}); // end post
}); // end submit

$('.login').submit(function(e) {
      
		e.preventDefault();	
		var error = 0;
		var self = $(this);
		
	    var $email = self.find('[type=email]');
	    var $pass = self.find('[type=password]');

		
		var emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;


  		 if(!emailRegex.test($email.val())) {
			createErrTult("이메일을 적으세요", $email)
			error++;	
		}

		if( $pass.val().length>1 &&  $pass.val()!= $pass.attr('placeholder')  ) {
			$pass.removeClass('invalid_field');			
		} 
		else {
			createErrTult('비밀번호를 입력하세요.', $pass)
			error++;
		}

		
		if (error!=0)return;
		self.find('[type=submit]').attr('disabled', 'disabled');

		self.children().fadeOut(300,function(){ $(this).remove() })
		$('<p class="login__title">sign in <br><span class="login-edition">welcome to A.Movie</span></p><p class="success">You have successfully<br> signed in!</p>').appendTo(self)
		.hide().delay(300).fadeIn();


		// var formInput = self.serialize();
		// $.post(self.attr('action'),formInput, function(data){}); // end post
}); // end submit



$('.loginout').submit(function(e) {
      
	e.preventDefault();	
	var error = 0;
	var self = $(this);
	
	var $email = self.find('[type=email]');
	var $pass = self.find('[type=password]');

	var $phone = self.find('[id=phone]');

	var $date = self.find('[id=shDateEnd]');
	
	var phoneRegex = /^[0-9]{3,4}-?[0-9]{4}$/;
	var emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	var dateRegex = /^\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$/


	   if(!emailRegex.test($email.val())) {
		createErrTult("이메일을 적으세요", $email)
		error++;	
	}
	if(!phoneRegex.test($phone.val())) {
		createErrTult("전호번호 입력", $phone)
		error++;	
	}
	if(!dateRegex.test($date.val())) {
		createErrTult("생년월일을 적으세요", $date)
		error++;	
	}


	if( $pass.val().length>1 &&  $pass.val()!= $pass.attr('placeholder')  ) {
		$pass.removeClass('invalid_field');			
	} 
	else {
		createErrTult('비밀번호를 입력하세요.', $pass)
		error++;
	}

	
	if (error!=0)return;
	self.find('[type=submit]').attr('disabled', 'disabled');

	self.children().fadeOut(300,function(){ $(this).remove() })
	$('<p class="login__title">회원가입 완료 <br><span class="login-edition">welcome to A.Movie</span></p>').appendTo(self)
	.hide().delay(300).fadeIn();


	// var formInput = self.serialize();
	// $.post(self.attr('action'),formInput, function(data){}); // end post
}); // end submit



(function () {
	'use strict'
  
	// Fetch all the forms we want to apply custom Bootstrap validation styles to
	var forms = document.querySelectorAll('.needs-validation')
  
	// Loop over them and prevent submission
	Array.prototype.slice.call(forms)
	  .forEach(function (form) {
		form.addEventListener('submit', function (event) {
		  if (!form.checkValidity()) {
			event.preventDefault()
			event.stopPropagation()
		  }
  
		  form.classList.add('was-validated')
		}, false)
	  })
  })()
		
		

function createErrTult(text, $elem){
			$elem.focus();
			$('<p />', {
				'class':'inv-em alert alert-danger',
				'html':'<span class="icon-warning"></span>' + text + ' <a class="close" data-dismiss="alert" href="#" aria-hidden="true"></a>',
			})
			.appendTo($elem.addClass('invalid_field').parent()) 
			.insertAfter($elem)
			.delay(4000).animate({'opacity':0},300, function(){ $(this).slideUp(400,function(){ $(this).remove() }) });
	}
});
