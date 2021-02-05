$("body").on('click', '#pregunta', publicarPregunta);





function publicarPregunta() {



	var pregunta = $('#pregunta').val();



	var token = $("meta[name='_csrf']").attr("content");

	var header = $("meta[name='_csrf_header']").attr("content");

	$(document).ajaxSend(function(e, xhr, options) {

		xhr.setRequestHeader(header, token);

	});



	$.ajax({

		url: "/pregunta/crear/" + pregunta,

		contentType: "application/json; charset=utf-8",

		data: { "pregunta": pregunta },

		type: "POST",

		success: function(response) {

            var alerta =

				"<div>" +

				"Publicado con exito" +

				"</div>";

			$('#preguntaError').html(alerta);



		},

		error: function(xhr, status, error) {



			var alerta =

				"<div class='alert alert-danger' role='alert'>" +

				"Error" +

				"</div>";



			$('#preguntaError').html(alerta);

		}

	});}