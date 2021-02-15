
$("body").on('click', '#botonPregunta', publicarPregunta);

function publicarPregunta() {

	var pregunta = $('#pregunta').val();
	var producto = $('#producto').val();

	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});

	var datos = {
		"pregunta": pregunta,
		"producto": producto
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

			usuario.style.textAlign = "center";
			texto.style.textAlign = "center";
			fecha.style.textAlign = "center";

			var apoyoU = document.createTextNode(response.nombreUsuario);
			var apoyoF = document.createTextNode(response.fechaDeCreacion);
			var apoyoT = document.createTextNode(pregunta);

			texto.appendChild(apoyoT);
			usuario.appendChild(apoyoU);
			fecha.appendChild(apoyoF);

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