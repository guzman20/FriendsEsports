package com.example.demo.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entidades.Pregunta;
import com.example.demo.entidades.Respuesta;
import com.example.demo.entidades.RespuestaDTO;
import com.example.demo.entidades.User;
import com.example.demo.servicios.PreguntasServicio;
import com.example.demo.servicios.RespuestaServicio;
import com.example.demo.servicios.UserServicio;
import com.fasterxml.jackson.databind.JsonNode;

@Controller
@RequestMapping(value = "/respuesta")
public class RespuestaController {
	
	@Autowired
	RespuestaServicio respuestaServicio;

	@Autowired
	UserServicio userServicio;

	@Autowired
	PreguntasServicio preguntaServicio;

	@RequestMapping(value = "/crear", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public RespuestaDTO publicarRespuesta(@RequestBody JsonNode values, HttpServletRequest request) {

		String texto = values.findValue("textoRespuesta").asText();

		if (texto != "") {

			Respuesta respuesta = new Respuesta();
			Long idUsuario = (long) request.getSession().getAttribute("idUsuario");
			User usuario = (User) userServicio.obtenerUsuario(idUsuario);
			Pregunta idpregunta = preguntaServicio.obtenerPregunta(values.findValue("idPregunta").asLong());
			respuesta = respuestaServicio.crearRespuesta(texto, usuario, idpregunta);
			
			RespuestaDTO respuestaDTO = respuestaServicio.conversionDTO(respuesta);
			return respuestaDTO;

		} else

			return null;

	}

}
