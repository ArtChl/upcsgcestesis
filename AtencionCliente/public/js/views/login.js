
$(document).ready(function(){
	
	var lv = new LoginValidator();

// main login form //

	$('#login-form').ajaxForm({
		beforeSubmit : function(formData, jqForm, options){
			if (lv.validateForm() == false){
				return false;
			} 	else{
			// append 'remember-me' option to formData to write local cookie //
				formData.push({name:'remember-me', value:$("input:checkbox:checked").length == 1})
				return true;
			}
		},
		success	: function(responseText, status, xhr, $form){
			if (status == 'success') window.location.href = '/inicio';
		},
		error : function (xhr, ajaxOptions, thrownError) {
            lv.showLoginError(xhr.responseText);
            $('#user-tf').text('');
            $('#clave-tf').text('');
            $('#user-tf').focus();
		}
	}); 
	$('#user-tf').focus();
	$("#div-alerta").hide();
})