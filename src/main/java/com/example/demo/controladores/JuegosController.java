package com.example.demo.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entidades.Tema;
import com.example.demo.servicios.TemaServicio;

@Controller
@RequestMapping(value = "/juegos")
public class JuegosController {
	
	@Autowired
	TemaServicio temaServicio;

	@RequestMapping(method = RequestMethod.GET,  value ="/{tema}" )
	public ModelAndView lol(@PathVariable("tema") String tema,HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		
		List<Tema> lTemas = temaServicio.ObtenerListaPorTemas(tema);

		mav.addObject("temas", lTemas);
		mav.setViewName("juegos/"+tema);
		return mav;

	}

}
