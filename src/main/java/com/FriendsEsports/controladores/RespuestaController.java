package com.FriendsEsports.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.FriendsEsports.entidades.Conversacion;
import com.FriendsEsports.entidades.ConversacionDTO;
import com.FriendsEsports.entidades.Juego;
import com.FriendsEsports.entidades.Respuesta;
import com.FriendsEsports.entidades.RespuestaDTO;
import com.FriendsEsports.entidades.Usuario;
import com.FriendsEsports.servicios.ConversacionServicio;
import com.FriendsEsports.servicios.JuegoServicio;
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

	@Autowired
	JuegoServicio juegoServicio;

	@RequestMapping(value = "/creado/{idConversacion}", method = RequestMethod.POST)
	public ModelAndView publicarRespuesta(@PathVariable("idConversacion") long idConversacion,
			HttpServletRequest request, @Valid @ModelAttribute("respuesta") RespuestaDTO respuestaDTO,
			BindingResult result, RedirectAttributes atributos) {

		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			atributos.addFlashAttribute("org.springframework.validation.BindingResult.respuesta", result);
			atributos.addFlashAttribute("respuesta", respuestaDTO);

			mav = new ModelAndView("redirect:/conversacion/" + idConversacion);
			List<Juego> juegos = juegoServicio.listarJuegos();

			mav.addObject("juegos", juegos);
		} else {

			String texto = request.getParameter("textoRespuesta");

			Conversacion c = conversacionServicio.obtenerConversacion(idConversacion);
			long id = (long) request.getSession().getAttribute("idUsuario");
			Usuario usuario = (Usuario) usuarioServicio.buscarUsuario(id);

			Respuesta t = new Respuesta();

			t = respuestaServicio.crearRespuesta(texto, usuario, c);

			mav = new ModelAndView("redirect:/conversacion/" + idConversacion);
			List<Juego> juegos = juegoServicio.listarJuegos();

			mav.addObject("juegos", juegos);
		}
		return mav;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/borrar/{idConversacion}/{idRespuesta}")
	public ModelAndView borrarRespuesta(@PathVariable("idRespuesta") long idRespuesta,
			@PathVariable("idConversacion") long idConversacion, HttpServletRequest request) {
		respuestaServicio.borrarRespuesta(idRespuesta);

		ModelAndView mav = new ModelAndView();

		mav.setViewName("redirect:/conversacion/" + idConversacion);
		return mav;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/editar/{idConversacion}/{idRespuesta}")
	public ModelAndView editarConversacion(@Valid @ModelAttribute("respuestaEditar") RespuestaDTO respuestaDTO,
			BindingResult result, RedirectAttributes atributos, @PathVariable("idRespuesta") long idRespuesta,
			@PathVariable("idConversacion") long idConversacion, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		if (result.hasErrors()) {
			atributos.addFlashAttribute("org.springframework.validation.BindingResult.respuestaEditar", result);
			atributos.addFlashAttribute("respuestaEditar", respuestaDTO);

		} else {

			String texto = request.getParameter("textoRespuesta");
			respuestaServicio.editarRespuesta(idRespuesta, texto);
		}
		mav.setViewName("redirect:/conversacion/" + idConversacion);
		return mav;

	}

}
