package com.example.demo.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entidades.Producto;
import com.example.demo.servicios.ProductoServicio;

@Controller
@RequestMapping(value = "/producto")
public class ProductoController {
	
	@Autowired
	ProductoServicio productoServicio;
	
	@RequestMapping(method = RequestMethod.GET, value = "/individual/{id}")
	public ModelAndView perfilProfesor(@PathVariable("id") long idProducto, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		Producto producto = productoServicio.obtenerProducto(idProducto);
		Boolean propietario = false;

		if (request.getSession().getAttribute("idUsuario") != null) {
			long idSession = (long) request.getSession().getAttribute("idUsuario");
			propietario = idSession == idProducto;
		}

		mav.addObject("propietario", propietario);
		mav.addObject("producto", producto);
		mav.setViewName("producto/individual");
		return mav;
	}

}
