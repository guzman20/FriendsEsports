package com.example.demo.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entidades.Conversacion;
import com.example.demo.entidades.Respuesta;
import com.example.demo.entidades.User;
import com.example.demo.servicios.ConversacionServicio;
import com.example.demo.servicios.RespuestaServicio;
import com.example.demo.servicios.UserServicio;

@Controller
@RequestMapping(value = "/conversacion")
public class ConversacionController {

	@Autowired
	ConversacionServicio conversacionServicio;

	@Autowired
	UserServicio userServicio;
	
	@Autowired 
	RespuestaServicio respuestaServicio;

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public ModelAndView crearConversacion(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		String tema = request.getParameter("tema");

		mav.addObject("tema", tema);
		mav.setViewName("conversacion/crear");
		return mav;

	}
	@RequestMapping(value = "/creado", method = RequestMethod.POST)
	public ModelAndView publicarConversacion(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		String tema = request.getParameter("tema");
		String titulo = request.getParameter("titulo");
		String texto = request.getParameter("texto");
		long id=(long) request.getSession().getAttribute("idUsuario");
		User usuario = (User)userServicio.obtenerUsuario(id);
		
		Conversacion t = new Conversacion();
		
		t = conversacionServicio.crearConversacion(tema, titulo, texto, usuario);
		
		mav.setViewName("redirect:/juegos/"+tema);
		return mav;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/{conversacion}/borrar/{idConversacion}")
	public ModelAndView borrarConversacion(@PathVariable("idConversacion") long idConversacion,@PathVariable("conversacion") String conversacion,HttpServletRequest request) {
		conversacionServicio.borrarConversacion(idConversacion);
		
		ModelAndView mav = new ModelAndView();

		mav.setViewName("redirect:/juegos/"+conversacion);
		return mav;

	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/{conversacion}/editar/{idConversacion}")
	public ModelAndView editarConversacion(@PathVariable("idConversacion") long idConversacion,@PathVariable("conversacion") String conversacion,HttpServletRequest request) {
		
		String titulo = request.getParameter("titulo");
		String texto = request.getParameter("texto");
		conversacionServicio.editarConversacion(idConversacion, titulo, texto);
		
		ModelAndView mav = new ModelAndView();

		mav.setViewName("redirect:/juegos/"+conversacion);
		return mav;

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{idConversacion}")
	public ModelAndView verConversacion(@PathVariable("idConversacion") long idConversacion,HttpServletRequest request) {
		
		Conversacion c = conversacionServicio.obtenerConversacion(idConversacion);
		List<Respuesta> r =respuestaServicio.listarRespuestas(c);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("conversacion", c);
		mav.addObject("respuestas", r);

		mav.setViewName("conversacion/conversacion");
		return mav;

	}

}
