package com.FriendsEsports.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.FriendsEsports.entidades.Conversacion;
import com.FriendsEsports.entidades.Juego;
import com.FriendsEsports.servicios.ConversacionServicio;
import com.FriendsEsports.servicios.JuegoServicio;

@Controller
@RequestMapping(value = "/juegos")
public class JuegosController {
	
	@Autowired
	ConversacionServicio conversacionServicio;
	
	@Autowired
	JuegoServicio juegoServicio;

	@RequestMapping(method = RequestMethod.GET,  value ="/{idJuego}" )
	public ModelAndView vistaJuego(@PathVariable("idJuego") long idJuego,HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		
		Juego juego = juegoServicio.obtenerPorId(idJuego);
		List<Conversacion> listaConversaciones = conversacionServicio.ObtenerListaPorJuegos(juego);

		mav.addObject("juego", juego);
		mav.addObject("conversaciones", listaConversaciones);
		mav.setViewName("juegos/vista");
		return mav;

	}

}
