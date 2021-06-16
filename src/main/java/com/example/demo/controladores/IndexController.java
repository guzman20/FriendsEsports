package com.example.demo.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@GetMapping({ "/", "index" })
	public ModelAndView index(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("index");
		return mav;

	}

}
