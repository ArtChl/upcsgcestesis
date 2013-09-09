
function LoginValidator(){
	this.showLoginError = function(m)
	{
		$('#div-alerta').text(m);
		$("#div-alerta").show();
	}
}

LoginValidator.prototype.validateForm = function()
{
	if ($('#user-tf').val() == ''){
		this.showLoginError('Por favor ingrese un usuario valido');
		return false;
	}	else if ($('#clave-tf').val() == ''){
		this.showLoginError('Por favor ingrese un password valido');
		return false;
	}	else{
		return true;
	}
}