







function cardnumber (objName, pattern, nullAllowedNy, message) {
// checkEmail = function (objName, pattern, nullAllowedNy, message) { {
    var regExp = /^\d{4}$/;
    return checkLogic (objName, pattern, nullAllowedNy, message, regExp);
}
function checkOnlyEnglish (objName, pattern, nullAllowedNy, message) {
// checkOnlyEnglish = function(obj, value, message) {
    var regExp = /^[A-Za-z]+$/;
    return checkLogic (objName, pattern, nullAllowedNy, message, regExp);
}

function checkmonth (objName, pattern, nullAllowedNy, message) {
// checkOnlyEnglish = function(obj, value, message) {
    var regExp =  /^\b(0?[1-9]|1[0-2])?\b$/;
    return checkLogic (objName, pattern, nullAllowedNy, message, regExp);
}
function checkyear (objName, pattern, nullAllowedNy, message) {
// checkOnlyEnglish = function(obj, value, message) {
    var regExp = /^\d{2}$/;
    return checkLogic (objName, pattern, nullAllowedNy, message, regExp);
}
function checkycvc (objName, pattern, nullAllowedNy, message) {
// checkOnlyEnglish = function(obj, value, message) {
    var regExp = /^\d{3}$/;
    return checkLogic (objName, pattern, nullAllowedNy, message, regExp);
}


function checkSelectNull (objName, pattern, message) {
    var obj = document.getElementById(objName);
    var objValue = document.getElementById(objName).value;
    var objFeedback = document.getElementById(objName+"Feedback");

    if(objValue != "" && objValue != null) {
        obj.classList.remove('is-invalid');
        obj.classList.add('form__name');
        return true;
    } else {
        checkLogicExpression(obj, objFeedback, pattern, message)
        return false;
    }
}



function checkLogic (objName, pattern, nullAllowedNy, message, regExp) {
// checkLogic = function (obj, value, pattern, message, regExp) {

    var obj = document.getElementById(objName);
    var objValue = document.getElementById(objName).value.trim();
    var objFeedback = document.getElementById(objName+"Feedback");
    
	
    if(nullAllowedNy == 0) {
        if(regExp.test(objValue)){
            // obj.removeClass("is-invalid");
            obj.classList.remove('is-invalid');
            obj.classList.add('form__name');
            return true;
        } else {
            checkLogicExpression (obj, objFeedback, pattern, message);
            return false;
        }
    } else if (nullAllowedNy == 1) {
        if(objValue != "" && objValue != null) {
            if(regExp.test(objValue)) {
                // obj.removeClass("is-invalid");
                obj.classList.remove('is-invalid');
                obj.classList.add('form__name');
                return true;
            } else {
                checkLogicExpression (obj, objFeedback, pattern, message);
                return false;
            }
        } else {
            obj.classList.remove('is-invalid');
            obj.classList.add('form__name');
            return true;
        }
    } else {
        alert("error: param nullAllowedNy in checkLogic");
        return false;
    }
}

function checkLogicExpression (obj, objFeedback, pattern, message) {
    switch(pattern) {
        case 1:
            // alert
            alert(message);
            obj.focus();
            break;
        case 2:
            // bootstrap validation
            //obj.addClass("is-invalid");
            obj.classList.remove('form__name');
            obj.classList.add('is-invalid');
            objFeedback.innerText = message;
            obj.focus();
            break;
        case 3:
            // bootstrap modal
            break;
    }
}