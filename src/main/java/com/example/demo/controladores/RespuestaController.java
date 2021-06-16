package com.example.demo.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entidades.Conversacion;
import com.example.demo.entidades.Respuesta;
import com.example.demo.entidades.RespuestaDTO;
import com.example.demo.entidades.User;
import com.example.demo.servicios.RespuestaServicio;
import com.example.demo.servicios.ConversacionServicio;
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
	ConversacionServicio conversacionServicio;

	@RequestMapping(value = "/crear", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public RespuestaDTO publicarRespuesta(@RequestBody JsonNode values, HttpServletRequest request) {

		String texto = values.findValue("textoRespuesta").asText();

		if (texto != "") {

			Respuesta respuesta = new Respuesta();
			Long idUsuario = (long) request.getSession().getAttribute("idUsuario");
			User usuario = (User) userServicio.obtenerUsuario(idUsuario);
			Conversacion idConversacion = conversacionServicio.obtenerConversacion(values.findValue("idConversacion").asLong());
			respuesta = respuestaServicio.crearRespuesta(texto, usuario, idConversacion);
			
			RespuestaDTO respuestaDTO = respuestaServicio.conversionDTO(respuesta);
			return respuestaDTO;

		} else

			return null;

	}
	
	@RequestMapping(value = "/borrar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Long borrarRespuesta(@RequestBody JsonNode values, HttpServletRequest request) {

		Long idRespuesta = values.findValue("idRespuesta").asLong();

		respuestaServicio.borrarRespuesta(idRespuesta);
		return idRespuesta;

	}
	
	@RequestMapping(value = "/editar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public RespuestaDTO editarConversacion(@RequestBody JsonNode values, HttpServletRequest request) {

		Long idRespuesta = values.findValue("idRespuesta").asLong();
		String respuesta = values.findValue("Respuesta").asText();
		

		RespuestaDTO respuestaDTO = respuestaServicio.conversionDTO(respuestaServicio.editarRespuesta(idRespuesta, respuesta));
		
		
		return respuestaDTO;

	}

}
