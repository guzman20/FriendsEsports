package com.example.demo.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entidades.Conversacion;
import com.example.demo.entidades.Respuesta;
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

	@RequestMapping(value = "/creado", method = RequestMethod.POST)
	public ModelAndView publicarRespuesta(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		
		String texto = request.getParameter("textoRespuesta");
		long idC = Long.parseLong(request.getParameter("idConversacion"));
		Conversacion c = conversacionServicio.obtenerConversacion(idC);
		long id=(long) request.getSession().getAttribute("idUsuario");
		User usuario = (User)userServicio.obtenerUsuario(id);
		
		Respuesta t = new Respuesta();
		
		t = respuestaServicio.crearRespuesta(texto, usuario, c);
		
		mav.setViewName("redirect:/conversacion/"+idC);
		return mav;

	}

}
