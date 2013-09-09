var express = require('express');
var http = require('http');
var path = require('path');
var orm = require("orm");
var config = require('./config');
var app = express();

// all environments
app.set('port', process.env.PORT || config.puerto);
app.set('views', __dirname + '/views');
app.set('view engine', 'jade');
app.use(express.favicon());
app.use(express.logger('dev'));
app.use(express.bodyParser());
app.use(express.methodOverride());
app.use(express.cookieParser('53844751-298d-4c9c-9b9e-a0beaa3644e8'));
app.use(express.session());
app.use(express.methodOverride());
app.use(require('stylus').middleware(__dirname + '/public'));
app.use(express.static(path.join(__dirname, 'public')));

// development only
if ('development' == app.get('env')) {
  app.use(express.errorHandler());
}

app.use(orm.express(config.dburl,{
	define: function(db,models,next){
		db.load('./repositorio/models',function(err){
			models.usuario = db.models.usuario;
		});
	}
}));

require('./routes/router')(app);

http.createServer(app).listen(app.get('port'), function(){
  console.log('Express server escuchando en el puerto ' + app.get('port'));
});
