package com.example.demo.controladores;



import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LeagueController {
	
	@GetMapping({ "lol" })
	public ModelAndView index(HttpServletRequest request) {
		
		
		ModelAndView mav = new ModelAndView();
		
		
		mav.setViewName("lol");
		return mav;

	}

}
