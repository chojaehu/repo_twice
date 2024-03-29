

let goUrlXdmLogin = "/login";
			
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

/*goList = function(thisPage) {
	document.querySelector("input[name=thisPage]").value = thisPage;
	form.action = goUrlXdmList;
	form.submit();
}
*/
