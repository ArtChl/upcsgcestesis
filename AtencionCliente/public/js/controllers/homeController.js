
function HomeController()
{

// bind event listeners to button clicks //
	var that = this;

// handle user logout //
	$('#btn-logout').click(function(){ that.attemptLogout(); });

	this.attemptLogout = function()
	{
		$.ajax({
			url: "/cerrarSesion",
			type: "POST",
			success: function(data){
	 			window.location.href = '/inicio';
			},
			error: function(jqXHR){
				console.log(jqXHR.responseText+' :: '+jqXHR.statusText);
			}
		});
	}
}
