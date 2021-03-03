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