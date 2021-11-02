package com.FriendsEsports.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.FriendsEsports.entidades.Juego;
import com.FriendsEsports.servicios.JuegoServicio;

@Controller
public class IndexController {

	@Autowired
	JuegoServicio juegoServicio;

	@GetMapping({ "/", "index" })
	public ModelAndView index(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		List<Juego> juegos = juegoServicio.listarJuegos();
		
		mav.addObject("juegos", juegos);

		mav.setViewName("index");
		return mav;

	}

}
