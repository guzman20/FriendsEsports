$("body").on('click', '#mostrarEditarPregunta', mostrarEditarPregunta);

function mostrarEditarPregunta() {
	
	$(this).siblings().css( "display", "initial" );
}