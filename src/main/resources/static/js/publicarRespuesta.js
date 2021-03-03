
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