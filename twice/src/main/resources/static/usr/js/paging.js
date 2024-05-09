// 페이징
fnGoList = function(thisPage) {
    document.querySelector("input[name=thisPage]").value = thisPage;
    //form.action = goUrlSdmList;
    //form.submit();
    
    let queryString = $("#formList").serialize();
    
    $.ajax({
		async: true
		, cache: false
		, type: "post"
		, url: goUrlSdmPaging+"?"+queryString
		, success: function(fragment) {
			$("#listData").replaceWith(fragment);
		}
		, error: function(jqXHR, textStatus, errorThrown) {
			//fnModalCaptionChange(0,"오류", "ajaxUpdate " + jqXHR.textStatus + " : " + jqXHR.errorThrown);
			alert("ajaxUpdate " + jqXHR.textStatus + " : " + jqXHR.errorThrown);
		}
	});
}