package com.example.demo.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entidades.Producto;
import com.example.demo.servicios.ProductoServicio;

@Controller
public class IndexController {
	
	@Autowired
	ProductoServicio productoService;

	@GetMapping({ "/", "index" })
	public ModelAndView index(HttpServletRequest request) {
		
		if(request.getAttribute("logIn")==null)
			request.setAttribute("logIn", false);
		
		ModelAndView mav = new ModelAndView();
		
		List<Producto> lProducto = productoService.listarProductos(8);
		
		mav.addObject("logIn",request.getAttribute("logIn"));
		mav.addObject("productos", lProducto);
		mav.setViewName("index");
		return mav;

	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/filtrado")
	public ModelAndView BuscarProducto(@RequestParam(name = "nombre") String nombre,
										HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		List<Producto> lProducto = productoService.listarProductoPorNombre(nombre);

		mav.addObject("logIn",request.getAttribute("logIn"));
		mav.addObject("productos", lProducto);
		mav.setViewName("index");

		return mav;
	}

}
