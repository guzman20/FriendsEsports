package com.FriendsEsports.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.FriendsEsports.entidades.Conversacion;
import com.FriendsEsports.entidades.Juego;
import com.FriendsEsports.entidades.Respuesta;
import com.FriendsEsports.entidades.Usuario;
import com.FriendsEsports.servicios.ConversacionServicio;
import com.FriendsEsports.servicios.JuegoServicio;
import com.FriendsEsports.servicios.RespuestaServicio;
import com.FriendsEsports.servicios.UsuarioServicio;

@Controller
@RequestMapping(value = "/conversacion")
public class ConversacionController {

	@Autowired
	ConversacionServicio conversacionServicio;

	@Autowired
	UsuarioServicio usuarioServicio;

	@Autowired
	RespuestaServicio respuestaServicio;

	@Autowired
	JuegoServicio juegoServicio;

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public ModelAndView crearConversacion(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		String juego = request.getParameter("juego");

		mav.addObject("juego", juego);
		mav.setViewName("conversacion/crear");
		return mav;

	}

	@RequestMapping(value = "/creado", method = RequestMethod.POST)
	public ModelAndView publicarConversacion(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/index");
		String juegoNombre = request.getParameter("juego");
		Juego juego = juegoServicio.obtenerPorNombre(juegoNombre);
		if (juego != null) {
			String titulo = request.getParameter("titulo");
			String texto = request.getParameter("texto");
			long id = (long) request.getSession().getAttribute("idUsuario");
			Usuario usuario = (Usuario) usuarioServicio.buscarUsuario(id);

			Conversacion t = new Conversacion();

			t = conversacionServicio.crearConversacion(juego, titulo, texto, usuario);

			mav.setViewName("redirect:/conversacion/" + t.getIdConversacion());
		} else {
			mav.setViewName("redirect:/conversacion/crear");
		}
		return mav;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/{conversacion}/borrar/{idConversacion}")
	public ModelAndView borrarConversacion(@PathVariable("idConversacion") long idConversacion,
			@PathVariable("conversacion") String conversacion, HttpServletRequest request) {
		conversacionServicio.borrarConversacion(idConversacion);

		ModelAndView mav = new ModelAndView();

		mav.setViewName("redirect:/juegos/" + conversacion);
		return mav;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/{conversacion}/editar/{idConversacion}")
	public ModelAndView editarConversacion(@PathVariable("idConversacion") long idConversacion,
			@PathVariable("conversacion") String conversacion, HttpServletRequest request) {

		String titulo = request.getParameter("titulo");
		String texto = request.getParameter("texto");
		conversacionServicio.editarConversacion(idConversacion, titulo, texto);

		ModelAndView mav = new ModelAndView();

		mav.setViewName("redirect:/juegos/" + conversacion);
		return mav;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/{idConversacion}")
	public ModelAndView verConversacion(@PathVariable("idConversacion") long idConversacion,
			HttpServletRequest request) {

		Conversacion c = conversacionServicio.obtenerConversacion(idConversacion);
		List<Respuesta> r = respuestaServicio.listarRespuestas(c);

		ModelAndView mav = new ModelAndView();

		mav.addObject("conversacion", c);
		mav.addObject("respuestas", r);

		mav.setViewName("conversacion/conversacion");
		return mav;

	}

}
