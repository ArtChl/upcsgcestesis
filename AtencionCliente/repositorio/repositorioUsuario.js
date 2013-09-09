RepositorioUsuario = function(){}

RepositorioUsuario.prototype.InicioSesion = function(model, user,pass, callback){
	console.log(user);
	console.log(pass);
	model.usuario.find({login:user},function(error,resultado){
		if(error){			
			callback(new Error('Error inesperado'));
		}
		else{
			if(resultado != null && resultado[0] != undefined){				
				console.log(resultado[0].clave);
				if(resultado[0].clave == pass){
					callback(null,resultado);
				}
				else{
					callback(new Error('Password inválido'));
				}
			}
			else{
				callback(new Error('Usuario no existe'));
			}
		}
	});
}

module.exports.RepositorioUsuario = RepositorioUsuario;