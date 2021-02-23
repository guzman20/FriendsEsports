
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

//ESTO ES PUBLICAR RESPUESTAAAAAAA
			var fila = document.createElement("div");
			var usuario = document.createElement("span");
			var texto = document.createElement("span");
			var fecha = document.createElement("span");
//			var boton = document.createElement("button");
//			
//			boton.setAttribute("type", "button");
//  			boton.setAttribute("value", "Responder");
//			boton.id = "botonRespuesta";
//			boton.style.textAlign = "center";
//			boton.style.margin = "auto";
			
			fila.className = "row"
			usuario.className = "col-2";
			texto.className = "col-4";
			fecha.className = "col-6";
			
			usuario.style.textAlign = "center";
			texto.style.textAlign = "center";
			fecha.style.textAlign = "center";

			var apoyoU = document.createTextNode(response.usuario);
			var apoyoF = document.createTextNode(response.fechaDeCreacion);
			var apoyoT = document.createTextNode(textoRespuesta);
			
//			tdAsistente.appendChild(boton);
			texto.appendChild(apoyoT);
			usuario.appendChild(apoyoU);
			fecha.appendChild(apoyoF);
			
//			fila.appendChild(tdAsistente);
			fila.appendChild(usuario);
			fila.appendChild(texto);
			fila.appendChild(fecha);

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