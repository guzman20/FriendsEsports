package com.example.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.servicios.PreguntasServicio;

@Controller
@RequestMapping(value = "/pregunta")
public class PreguntaController {
	
	@Autowired
	PreguntasServicio preguntasServicio;
	
	@RequestMapping(value = "/crear/{pregunta}",method = RequestMethod.POST)
	@ResponseBody
	public String checkUsernameAvailability(
	@PathVariable("pregunta") String pregunta)
	{
	
	return "false";
	
	}

}
