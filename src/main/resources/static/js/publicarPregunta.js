$("body").on('click', '#crearBotonPregunta', publicarPregunta);

function publicarPregunta() {

	var preguntaTexto = $('#preguntaTexto').val();
	var idProducto = $('#idProducto').val();

	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});

	var datos = {
		"preguntaTexto": preguntaTexto,
		"idProducto": idProducto
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
			
			var columnaFormulario = document.createElement("td");
			var formulario = document.createElement("form");
			var boton = document.createElement("button");
			var i = document.createElement("i");
			var idPregunta = document.createElement("td");
			
			var tdAsistente = document.createElement("td");
			var boton = document.createElement("input");
			
			boton.setAttribute("type", "button");
  			boton.setAttribute("value", "Responder");
			boton.style.textAlign = "center";
			boton.style.margin = "auto";
			
			usuario.style.textAlign = "center";
			texto.style.textAlign = "center";
			fecha.style.textAlign = "center";
			boton.type= "button";
			boton.value= response.idPregunta;
			boton.classList="btn btn-primary";
			i.classList="far fa-trash-alt";
			boton.id="botonPreguntaBorrar";
			idPregunta.style.display="none";
			idPregunta.id=response.idPregunta;


			var apoyoU = document.createTextNode(response.nombreUsuario);
			var apoyoF = document.createTextNode(response.fechaDeCreacion);
			var apoyoT = document.createTextNode(preguntaTexto);
			var apoyoB = document.createTextNode("borrar");
			
			tdAsistente.appendChild(boton);
			texto.appendChild(apoyoT);
			usuario.appendChild(apoyoU);
			fecha.appendChild(apoyoF);
			
			fila.appendChild(tdAsistente);

			texto.appendChild(apoyoT);
			usuario.appendChild(apoyoU);
			fecha.appendChild(apoyoF);
			boton.appendChild(i);
			boton.appendChild(apoyoB);
			
			formulario.appendChild(boton);
			columnaFormulario.appendChild(formulario);
			fila.appendChild(usuario);
			fila.appendChild(texto);
			fila.appendChild(fecha);
			fila.appendChild(idPregunta);
			fila.appendChild(columnaFormulario);

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