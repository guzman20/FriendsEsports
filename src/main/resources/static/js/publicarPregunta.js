$("body").on('click', '#pregunta','#producto', publicarPregunta);





function publicarPregunta() {



	var pregunta = $('#pregunta').val();
	var producto = $('#producto').val();



	var token = $("meta[name='_csrf']").attr("content");

	var header = $("meta[name='_csrf_header']").attr("content");

	$(document).ajaxSend(function(e, xhr, options) {

		xhr.setRequestHeader(header, token);

	});



	$.ajax({

		url: "/pregunta/crear/"+ producto + "/" + pregunta,

		contentType: "application/json; charset=utf-8",

		data: { "pregunta": pregunta,
				"producto" : producto},

		type: "POST",

		success: function(response) {

            var alerta =

				"<td>" +

				pregunta +

				"</td>";

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