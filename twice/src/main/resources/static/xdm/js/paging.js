

goList = function(thisPage) {
	document.querySelector("input[name=thisPage]").value = thisPage;
	form.action = goUrlXdmList;
	form.submit();
}