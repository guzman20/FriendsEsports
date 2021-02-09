
$("body").on('click', '#pregunta','#producto', publicarPregunta);

function publicarPregunta() {

	var pregunta = $('#pregunta').val();
	var producto = $('#producto').val();

	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});

	var datos = { "pregunta": pregunta,
				"producto" : producto};

	$.ajax({
		url: "/pregunta/crear/",
		contentType: "application/json; charset=utf-8",
		dataType:"json",
		data:JSON.stringify(datos),
		type: "POST",
		success: function(response) {
            var fila = document.createElement("tr");
			var usuario = document.createElement("td");
			var texto = document.createElement("td");
			var fecha = document.createElement("td");

			var apoyoU=document.createTextNode("Jose");
			var apoyoF=document.createTextNode("21/03/2017");
			var apoyoT = document.createTextNode(pregunta);

			texto.appendChild(apoyoT);
			usuario.appendChild(apoyoU);
			fecha.appendChild(apoyoF);

			fila.appendChild(usuario);-
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

	});}