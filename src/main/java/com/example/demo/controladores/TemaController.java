package com.example.demo.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entidades.Tema;
import com.example.demo.entidades.User;
import com.example.demo.servicios.TemaServicio;
import com.example.demo.servicios.UserServicio;

@Controller
@RequestMapping(value = "/tema")
public class TemaController {

	@Autowired
	TemaServicio temaServicio;

	@Autowired
	UserServicio userServicio;

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public ModelAndView creartema(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		String tema = request.getParameter("tema");

		mav.addObject("tema", tema);
		mav.setViewName("tema/crear");
		return mav;

	}
	@RequestMapping(value = "/creado", method = RequestMethod.POST)
	public ModelAndView publicartema(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		String tema = request.getParameter("tema");
		String titulo = request.getParameter("titulo");
		String texto = request.getParameter("texto");
		long id=(long) request.getSession().getAttribute("idUsuario");
		User usuario = (User)userServicio.obtenerUsuario(id);
		
		Tema t = new Tema();
		
		t = temaServicio.crearTema(tema, titulo, texto, usuario);
		
		mav.setViewName("redirect:/juegos/"+tema);
		return mav;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/{tema}/borrar/{idTema}")
	public ModelAndView borrartema(@PathVariable("idTema") long idTema,@PathVariable("tema") String tema,HttpServletRequest request) {
		temaServicio.borrarTema(idTema);
		
		ModelAndView mav = new ModelAndView();

		mav.setViewName("redirect:/juegos/"+tema);
		return mav;

	}

}
