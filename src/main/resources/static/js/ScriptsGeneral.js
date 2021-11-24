$("body").on('click', '#botonPreguntaBorrar', borrarPregunta);

function borrarPregunta() {

	var idPregunta = $(this).val();

	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});

	var datos = {
		"idPregunta": idPregunta
	};

	$.ajax({
		url: "/pregunta/borrar/",
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		data: JSON.stringify(datos),
		type: "POST",
		success: function(response) {

			var alerta =
				"<div>" +
				"Bien</div>";
			
			
			
			$('#'+response).parent().remove();
				
				
			$('#preguntaError').html(alerta);
		},
		error: function(xhr, status, error) {

			var alerta =
				"<div class='alert alert-danger' role='alert'>" +
				"Error: No se pudo borrar</div>";

			$('#preguntaError').html(alerta);
		}

	});
}

$("body").on('click', '#botonRespuestaBorrar', borrarRespuesta);

function borrarRespuesta() {

	var idRespuesta = $(this).val();

	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});

	var datos = {
		"idRespuesta": idRespuesta
	};

	$.ajax({
		url: "/respuesta/borrar/",
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		data: JSON.stringify(datos),
		type: "POST",
		success: function(response) {

			var alerta =
				"<div>" +
				"Bien</div>";
			
			
			$('#'+'Respuesta'+response).parent().remove();
				
				
			$('#RespuestaError').html(alerta);
		},
		error: function(xhr, status, error) {

			var alerta =
				"<div class='alert alert-danger' role='alert'>" +
				"Error: No se pudo borrar</div>";

			$('#PreguntaError').html(alerta);
		}

	});
}

$("body").on('click', '#botonPreguntaEditar', editarPregunta);

function editarPregunta() {

	var pregunta = $(this).prev().val();
	var idPregunta = $(this).val();

	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});

	var datos = {
		"idPregunta": idPregunta,
		"pregunta" : pregunta
	};

	$.ajax({
		url: "/pregunta/editar/",
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		data: JSON.stringify(datos),
		type: "POST",
		success: function(response) {

			var alerta =
				"<div>" +
				"Bien</div>";
			
			
			
			$('#'+response.idPregunta).val(pregunta);
				
				
			$('#preguntaError').html(alerta);
		},
		error: function(xhr, status, error) {

			var alerta =
				"<div class='alert alert-danger' role='alert'>" +
				"Error: No se pudo borrar</div>";

			$('#preguntaError').html(alerta);
		}

	});
}

$("body").on('click', '#botonEditarRespuesta', editarRespuesta);

function editarRespuesta() {

	var respuesta = $(this).prev().val();
	var idRespuesta = $(this).val();

	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});

	var datos = {
		"idRespuesta": idRespuesta,
		"Respuesta" : respuesta
	};

	$.ajax({
		url: "/respuesta/editar/",
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		data: JSON.stringify(datos),
		type: "POST",
		success: function(response) {

			var alerta =
				"<div>" +
				"Bien</div>";
			
			
			$('#'+'RespuestaTexto'+response.idRespuestaDTO).text(respuesta);
				
			$('#PreguntaError').html(alerta);
		},
		error: function(xhr, status, error) {

			var alerta =
				"<div class='alert alert-danger' role='alert'>" +
				"Error: No se pudo borrar</div>";

			$('#PreguntaError').html(alerta);
		}

	});
}

$("body").on('click', '#mostrar', mostrar);

function mostrar() {
	
	$(this).next().slideToggle(400);
}

$("body").on('click', '#crearBotonPregunta', publicarPregunta);

function publicarPregunta() {

	var preguntaTexto = $('#preguntaTexto').val();
	var idProducto = $('#idProducto').val();

	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});

	var datos = {
		"preguntaTexto": preguntaTexto,
		"idProducto": idProducto
	};

	$.ajax({
		url: "/pregunta/crear/",
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		data: JSON.stringify(datos),
		type: "POST",
		success: function(response) {

			var fila = document.createElement("tr");
			var usuario = document.createElement("td");
			var texto = document.createElement("td");
			var fecha = document.createElement("td");
			var columnaFormulario = document.createElement("td");
			var formulario = document.createElement("form");
			var boton = document.createElement("button");
			var i = document.createElement("i");
			var idPregunta = document.createElement("td");
			
			var botonResponder = document.createElement("button");
			var divResponder = document.createElement("div");
			var textResponder = document.createElement("textarea");
			var botonAceptar = document.createElement("button");
			
			usuario.style.textAlign = "center";
			texto.style.textAlign = "center";
			fecha.style.textAlign = "center";
			boton.type= "button";
			boton.value= response.idPregunta;
			boton.classList="btn btn-primary";
			
			botonResponder.type= "button";
			botonResponder.id = "mostrarResponderPregunta";
			botonResponder.classList="btn btn-primary";
			divResponder.style.display = "none";
			textResponder.id = "textoRespuesta";
			textResponder.name = "textoRespuesta";
			textResponder.classList = "form-control";
			
			botonAceptar.type= "button";
			botonAceptar.id = "botonRespuesta";
			botonAceptar.classList="btn btn-primary";
			botonAceptar.value = response.idPregunta;
			
			i.classList="far fa-trash-alt";
			boton.id="botonPreguntaBorrar";
			idPregunta.style.display="none";
			idPregunta.id=response.idPregunta;


			var apoyoU = document.createTextNode(response.nombreUsuario);
			var apoyoF = document.createTextNode(response.fechaDeCreacion);
			var apoyoT = document.createTextNode(preguntaTexto);
			var apoyoB = document.createTextNode("Borrar");
			var apoyoBR = document.createTextNode("Responder");
			var apoyoAceptar = document.createTextNode("Aceptar");
			
			texto.appendChild(apoyoT);
			usuario.appendChild(apoyoU);
			fecha.appendChild(apoyoF);
	
	

			texto.appendChild(apoyoT);
			usuario.appendChild(apoyoU);
			fecha.appendChild(apoyoF);
			boton.appendChild(i);
			boton.appendChild(apoyoB);
			//botonResponder.appendChild(i);
			botonResponder.appendChild(apoyoBR);
			botonAceptar.appendChild(apoyoAceptar);
			
			formulario.appendChild(botonResponder);
			formulario.appendChild(boton);
			divResponder.appendChild(textResponder);
			divResponder.appendChild(botonAceptar)
			formulario.appendChild(divResponder);			
	
			columnaFormulario.appendChild(formulario);
			
			fila.appendChild(usuario);
			fila.appendChild(texto);
			fila.appendChild(fecha);
			fila.appendChild(idPregunta);
			fila.appendChild(columnaFormulario);
			
			$('#cuerpoTabla').append(fila);
		},
		error: function(xhr, status, error) {

			var alerta =
				"<div class='alert alert-danger' role='alert'>" +
				"Error </div>";

			$('#preguntaError').html(alerta);
		}

	});
}


$("body").on('click', '#botonRespuesta', publicarRespuesta);

function publicarRespuesta() {

	var idPregunta = $(this).val();
	var textoRespuesta = $(this).prev().val();

	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});

	var datos = {
		"idPregunta": idPregunta,
		"textoRespuesta": textoRespuesta,
	};

	$.ajax({
		url: "/respuesta/crear/",
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		data: JSON.stringify(datos),
		type: "POST",
		success: function(response) {

			var fila = document.createElement("div");
			var usuario = document.createElement("span");
			var texto = document.createElement("span");
			var fecha = document.createElement("span");
			var nombre = document.createElement("span");
			var botones = document.createElement("span");
			var borrar = document.createElement("button");
			var i = document.createElement("i");
			var br = document.createElement("br");
			var mostrar = document.createElement("button");
			var oculto= document.createElement("span");
			var editar = document.createElement("textarea");
			var aceptar = document.createElement("button");
			
			nombre.id="Respuesta"+response.idRespuestaDTO;
			nombre.style.display = "none";
			borrar.id="botonRespuestaBorrar"
			borrar.value=response.idRespuestaDTO;
			texto.id="RespuestaTexto"+response.idRespuestaDTO;
			mostrar.id= "mostrar";
			oculto.style.display="none";
			editar.id="textoEditarRespuesta";
			aceptar.id="botonEditarRespuesta";
			aceptar.value=response.idRespuestaDTO;
			
			fila.className = "row"
			usuario.className = "col-3";
			texto.className = "col-3";
			fecha.className = "col-3";
			botones.className = "col-3";
			borrar.className = "btn btn-primary";
			i.className = "far fa-trash-alt";
			mostrar.className = "btn btn-primary";
			editar.className ="form-control";
			aceptar.className="btn btn-primary";
			
			
			usuario.style.textAlign = "center";
			texto.style.textAlign = "center";
			fecha.style.textAlign = "center";
			botones.style.textAlign = "center";

			var apoyoU = document.createTextNode(response.usuario);
			var apoyoF = document.createTextNode(response.fechaDeCreacion);
			var apoyoT = document.createTextNode(textoRespuesta);
			var apoyoB = document.createTextNode("borrar");
			var apoyoM = document.createTextNode("Editar");
			var apoyoA = document.createTextNode("Aceptar");
			
			oculto.appendChild(editar);
			oculto.appendChild(aceptar);
			borrar.appendChild(i);
			botones.appendChild(borrar);
			botones.appendChild(br);
			botones.appendChild(mostrar);
			botones.appendChild(oculto);
			
			borrar.appendChild(apoyoB);
			texto.appendChild(apoyoT);
			usuario.appendChild(apoyoU);
			fecha.appendChild(apoyoF);
			mostrar.appendChild(apoyoM);
			aceptar.appendChild(apoyoA);
			
			fila.appendChild(usuario);
			fila.appendChild(texto);
			fila.appendChild(fecha);
			fila.appendChild(nombre);
			fila.appendChild(botones);

			$('#Respuesta'+response.idPregunta).append(fila);
		},
		error: function(xhr, status, error) {

			var alerta =
				"<div class='alert alert-danger' role='alert'>" +
				"Error </div>";

			$('#preguntaError').html(alerta);
		}

	});
}

$("body").on('click', '#mostrarEditarUsuario', mostrarEditarUsuario);

function mostrarEditarUsuario() {
	
	$('#modificar').slideToggle(400);
}
$("body").on('click', '.editar', editar);

function editar(){
	
	$(this).parent().parent().next().slideToggle(400);
	
}

$("body").on('click', '.abrir', abrir);

function abrir(){
	
	$(this).parent().parent().next().next().slideToggle(400);
	
}