$("body").on('click', '#mostrarEditarPregunta', mostrar);
$("body").on('click', '#mostrarResponderPregunta', mostrar);

function mostrar() {
	
	$(this).siblings().css( "display", "initial" );
}