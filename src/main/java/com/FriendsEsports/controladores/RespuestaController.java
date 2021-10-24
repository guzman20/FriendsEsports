package com.FriendsEsports.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.FriendsEsports.entidades.Conversacion;
import com.FriendsEsports.entidades.Respuesta;
import com.FriendsEsports.entidades.Usuario;
import com.FriendsEsports.servicios.ConversacionServicio;
import com.FriendsEsports.servicios.RespuestaServicio;
import com.FriendsEsports.servicios.UsuarioServicio;
import com.fasterxml.jackson.databind.JsonNode;

@Controller
@RequestMapping(value = "/respuesta")
public class RespuestaController {

	@Autowired
	RespuestaServicio respuestaServicio;

	@Autowired
	UsuarioServicio usuarioServicio;

	@Autowired
	ConversacionServicio conversacionServicio;

	@RequestMapping(value = "/creado", method = RequestMethod.POST)
	public ModelAndView publicarRespuesta(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		
		String texto = request.getParameter("textoRespuesta");
		long idC = Long.parseLong(request.getParameter("idConversacion"));
		Conversacion c = conversacionServicio.obtenerConversacion(idC);
		long id=(long) request.getSession().getAttribute("idUsuario");
		Usuario usuario = (Usuario)usuarioServicio.obtenerUsuario(id);
		
		Respuesta t = new Respuesta();
		
		t = respuestaServicio.crearRespuesta(texto, usuario, c);
		
		mav.setViewName("redirect:/conversacion/"+idC);
		return mav;

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/borrar/{idConversacion}/{idRespuesta}")
	public ModelAndView borrarRespuesta(@PathVariable("idRespuesta") long idRespuesta,@PathVariable("idConversacion") long idConversacion,HttpServletRequest request) {
		respuestaServicio.borrarRespuesta(idRespuesta);
		
		ModelAndView mav = new ModelAndView();

		mav.setViewName("redirect:/conversacion/"+idConversacion);
		return mav;

	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/editar/{idConversacion}/{idRespuesta}")
	public ModelAndView editarConversacion(@PathVariable("idRespuesta") long idRespuesta,@PathVariable("idConversacion") long idConversacion,HttpServletRequest request) {
		

		String texto = request.getParameter("texto");
		respuestaServicio.editarRespuesta(idRespuesta, texto);
		
		ModelAndView mav = new ModelAndView();

		mav.setViewName("redirect:/conversacion/"+idConversacion);
		return mav;

	}

}
