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
import com.FriendsEsports.servicios.ConversacionServicio;

@Controller
@RequestMapping(value = "/juegos")
public class JuegosController {
	
	@Autowired
	ConversacionServicio conversacionServicio;

	@RequestMapping(method = RequestMethod.GET,  value ="/{juego}" )
	public ModelAndView cargarJuegos(@PathVariable("juego") String juego,HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		
		List<Conversacion> listaConversaciones = conversacionServicio.ObtenerListaPorJuegos(juego);

		mav.addObject("conversaciones", listaConversaciones);
		mav.setViewName("juegos/"+juego);
		return mav;

	}

}
