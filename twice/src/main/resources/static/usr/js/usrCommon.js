		let goUrlXdmLogin = "/useIndex";
        let form = document.querySelector("form[name=formList]");
        let goUrlXdmList = "/usePerformanceList";



		//로그 아웃 
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
		
		// 검색
		window
				.addEventListener(
						'load',
						function() {

							document.getElementById("btnSearch").onclick = function() {
								form.action = goUrlXdmList;
								form.submit();
							};

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
		
		
		// 엔터키 막기
		document.addEventListener("keydown", function(event) {
		  if (event.key === "Enter") {
		    event.preventDefault();
		  }
		});
		
		