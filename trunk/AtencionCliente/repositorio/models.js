module.exports = function(db,cb){
	db.define('usuario',{
	    	id: Number,
	    	idtrabajador: Number,
	    	login: String,
	    	clave: String,
	    	fecharegistro: Date});

	return cb();
};