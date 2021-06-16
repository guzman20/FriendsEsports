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

import com.example.demo.entidades.Conversacion;
import com.example.demo.servicios.ConversacionServicio;

@Controller
@RequestMapping(value = "/juegos")
public class JuegosController {
	
	@Autowired
	ConversacionServicio conversacionServicio;

	@RequestMapping(method = RequestMethod.GET,  value ="/{tema}" )
	public ModelAndView cargarJuegos(@PathVariable("tema") String tema,HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		
		List<Conversacion> lconversaciones = conversacionServicio.ObtenerListaPorTemas(tema);

		mav.addObject("conversaciones", lconversaciones);
		mav.setViewName("juegos/"+tema);
		return mav;

	}

}
