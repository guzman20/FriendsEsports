package com.example.demo.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/juegos")
public class JuegosController {

	@GetMapping({ "/lol" })
	public ModelAndView lol(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("juegos/lol");
		return mav;

	}

	@GetMapping({ "/valorant" })
	public ModelAndView valorant(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("juegos/valorant");
		return mav;

	}

	@GetMapping({ "/csgo" })
	public ModelAndView csgo(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("juegos/csgo");
		return mav;

	}

}
