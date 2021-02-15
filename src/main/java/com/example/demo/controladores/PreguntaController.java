package com.example.demo.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entidades.Pregunta;
import com.example.demo.entidades.PreguntaDTO;
import com.example.demo.entidades.Producto;
import com.example.demo.entidades.User;
import com.example.demo.servicios.PreguntasServicio;
import com.example.demo.servicios.ProductoServicio;
import com.example.demo.servicios.UserServicio;
import com.fasterxml.jackson.databind.JsonNode;

@Controller
@RequestMapping(value = "/pregunta")
public class PreguntaController {

	@Autowired
	PreguntasServicio preguntasServicio;

	@Autowired
	UserServicio userServicio;

	@Autowired
	ProductoServicio productoServicio;

	@RequestMapping(value = "/crear", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public PreguntaDTO publicarPregunta(@RequestBody JsonNode values, HttpServletRequest request) {

		String texto = values.findValue("pregunta").asText();

		if (texto != "") {

			Pregunta pregunta = new Pregunta();
			Long idUsuario = (long) request.getSession().getAttribute("idUsuario");
			User usuario = (User) userServicio.obtenerUsuario(idUsuario);
			Producto producto = productoServicio.obtenerProducto(values.findValue("producto").asLong());
			pregunta = preguntasServicio.crearPregunta(texto, usuario, producto);
			
			PreguntaDTO preguntaDTO = preguntasServicio.conversionDTO(pregunta);
			return preguntaDTO;

		} else

			return null;

	}

}
