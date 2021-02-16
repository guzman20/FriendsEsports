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