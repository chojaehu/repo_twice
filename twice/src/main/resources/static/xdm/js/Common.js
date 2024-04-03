

			
		document.getElementById("Logout").onclick = function() {
			$.ajax({
				async: true 
				,cache: false
				,type: "post"
				,url: "/loginoutXdm" 
				,success: function(response) {
					if(response.rt == "success") {
						valLogin();
					} 
					else {
				 		alert("로그아웃 실패")
					}
				}
				,error : function(jqXHR, textStatus, errorThrown){
					alert("ajaxUpdate " + jqXHR.textStatus + " : " + jqXHR.errorThrown);
				}
			});
		}
		function valLogin(){
			location.href = goUrlXdmLogin;
		}
		
		
		
		window
				.addEventListener(
						'load',
						function() {
							$("#shDateStart, #shDateEnd").datetimepicker({
								timepicker : false,
								format : 'Y-m-d',

							});

							document.getElementById("btnSearch").onclick = function() {
								form.action = goUrlXdmList;
								form.submit();
							};

							goForm = function(keyValue) {
								seq.value = keyValue;
								form.action = goUrlXdmForm;
								form.submit();
							}
							goList = function(thisPage) {
								document.querySelector("input[name=thisPage]").value = thisPage;
								form.action = goUrlXdmList;
								form.submit();
							}
						});
		function enterkey() {

			if (window.event.keyCode == 13) {
				form.action = goUrlXdmList;
				form.submit();
			}
		}

/*goList = function(thisPage) {
	document.querySelector("input[name=thisPage]").value = thisPage;
	form.action = goUrlXdmList;
	form.submit();
}
*/
