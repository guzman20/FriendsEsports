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