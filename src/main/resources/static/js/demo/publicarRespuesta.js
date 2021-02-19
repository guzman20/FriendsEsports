
$("body").on('click', '#botonRespuesta', publicarRespuesta);

function publicarRespuesta() {

	var pregunta = $('#pregunta').val();
	var idusuariopregunta = $('#idusuariopregunta').val();

	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});

	var datos = {
		"respuesta": respuesta,
		"idusuariopregunta": idusuariopregunta
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
			var tdAsistente = document.createElement("td");
			var boton = document.createElement("input");
			
			boton.setAttribute("type", "button");
  			boton.setAttribute("value", "Responder");
			boton.style.textAlign = "center";
			boton.style.margin = "auto";
			
			usuario.style.textAlign = "center";
			texto.style.textAlign = "center";
			fecha.style.textAlign = "center";

			var apoyoU = document.createTextNode(response.nombreUsuario);
			var apoyoF = document.createTextNode(response.fechaDeCreacion);
			var apoyoT = document.createTextNode(pregunta);
			
			tdAsistente.appendChild(boton);
			texto.appendChild(apoyoT);
			usuario.appendChild(apoyoU);
			fecha.appendChild(apoyoF);
			
			fila.appendChild(tdAsistente);
			fila.appendChild(usuario);
			fila.appendChild(texto);
			fila.appendChild(fecha);

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