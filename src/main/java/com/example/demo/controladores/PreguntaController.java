package com.example.demo.controladores;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entidades.Pregunta;
import com.example.demo.entidades.Producto;
import com.example.demo.entidades.User;
import com.example.demo.servicios.PreguntasServicio;
import com.example.demo.servicios.ProductoServicio;
import com.example.demo.servicios.UserServicio;

@Controller
@RequestMapping(value = "/pregunta")
public class PreguntaController {
	
	@Autowired
	PreguntasServicio preguntasServicio;
	
	@Autowired
	UserServicio userServicio;
	
	@Autowired
	ProductoServicio productoServicio;
	
	@RequestMapping(value = "/crear/{producto}/{pregunta}",method = RequestMethod.POST)
	@ResponseBody
	public String publicarPregunta(
	@PathVariable("pregunta") String pregunta,
	@PathVariable("producto") Long idProducto
	, HttpServletRequest request)
	{
	
	Pregunta preguntaReal =new Pregunta();
	Long idUsuario = (long) request.getSession().getAttribute("idUsuario");
	User usuario = (User) userServicio.obtenerUsuario(idUsuario);
	Producto producto = productoServicio.obtenerProducto(idProducto);
	preguntaReal = preguntasServicio.crearPregunta(pregunta,usuario,producto);
	
	
	
	return "false";
	
	}

}
