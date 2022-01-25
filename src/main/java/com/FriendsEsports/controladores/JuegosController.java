package com.FriendsEsports.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.FriendsEsports.entidades.Conversacion;
import com.FriendsEsports.entidades.ConversacionDTO;
import com.FriendsEsports.entidades.Juego;
import com.FriendsEsports.entidades.Usuario;
import com.FriendsEsports.servicios.ConversacionServicio;
import com.FriendsEsports.servicios.JuegoServicio;

@Controller
@RequestMapping(value = "/juegos")
public class JuegosController {

	@Autowired
	ConversacionServicio conversacionServicio;

	@Autowired
	JuegoServicio juegoServicio;

	@RequestMapping(method = RequestMethod.GET, value = "/{idJuego}")
	public ModelAndView vistaJuego(@PathVariable("idJuego") long idJuego, HttpServletRequest request,
			@ModelAttribute("conversacion") ConversacionDTO ConversacionDTO) {

		ModelAndView mav = new ModelAndView();

		Juego juego = juegoServicio.obtenerPorId(idJuego);
		List<Conversacion> listaConversaciones = conversacionServicio.ObtenerListaPorJuegos(juego);
		List<Juego> listaJuegos = juegoServicio.listarJuegos();

		mav.addObject("juegos", listaJuegos);
		mav.addObject("juego", juego);
		mav.addObject("conversaciones", listaConversaciones);
		mav.setViewName("juegos/vista");
		return mav;

	}

}
