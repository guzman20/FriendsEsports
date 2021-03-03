$("body").on('click', '#mostrar', mostrar);

function mostrar() {
	
	$(this).next().toggle();
}