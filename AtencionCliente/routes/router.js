
var RepositorioUsuario = require('../repositorio/repositorioUsuario').RepositorioUsuario;
var repositorioUsuario = new RepositorioUsuario();

module.exports = function(app){

	app.get('/', function(req,res){
		if(req.cookies.user == undefined || req.cookies.pass == undefined){
			res.render('login',{titulo:'Bienvenido - Por favor inicia sesion'})
		}
		else{
			var login = {user:req.cookies.user ,clave:req.cookies.pass };
			res.redirect('/inicio');
		}
	});

	app.post('/',function(req,res){
		var login = {user:req.param('usuario') ,clave:req.param('clave') };
		repositorioUsuario.InicioSesion(req.models,login.user,login.clave,function(err,resultado){
			if(err){
				console.log(err.message);
				res.send(400,err.message);
			}
			else{				
				req.session.user = login.user;
				if(req.param('remember-me') == 'true'){
					res.cookie('user',login.user,{maxAge:900000});
					res.cookie('clave',login.clave,{maxAge:900000});
				}
				res.redirect('/inicio');
			}
		});
	});

	app.get('/inicio', function(req,res){
		if(req.session.user == null){
			res.redirect('/');
		}
		else{
			res.render('home',{titulo:'Atención al Cliente', usuario: req.session.user});
		}
	});

	app.get('/cerrarSesion',function(req,res){
		res.clearCookie('user');
		res.clearCookie('pass');
		req.session.destroy(function(e){ res.redirect('/inicio'); });
	});

	app.get('/reinicioClave',function(req,res){
		res.render('reinicioClave',{titulo:'Reinicio de Clave', usuario: req.session.user});
	});

	app.get('/crearCuenta',function(req,res){
		res.render('crearCuenta',{titulo:'Crear Cuenta', usuario: req.session.user});
	});	

	app.get('/flotas',function(req,res){
		if(req.session.user == null){
			res.redirect('/');
		}
		else{
			res.render('consultaFlota',{titulo:'Consulta de Foltas', usuario: req.session.user});
		}
	});

	app.get('/consumos',function(req,res){
		if(req.session.user == null){
			res.redirect('/');
		}
		else{
			res.render('consultaConsumo',{titulo:'Consulta de Consumos', usuario: req.session.user});
		}
	});

	app.get('/depositos',function(req,res){
		if(req.session.user == null){
			res.redirect('/');
		}
		else{
			res.render('consultaDeposito',{titulo:'Consulta de Depósitos', usuario: req.session.user});
		}
	});

	app.get('/facturacion',function(req,res){
		if(req.session.user == null){
			res.redirect('/');
		}
		else{
			res.render('consultaFacturacion',{titulo:'Consulta de Facturación', usuario: req.session.user});
		}
	});

	app.get('*', function(req, res) { 
		res.render('404', { title: 'Página no encontrada'}); 
	});
}