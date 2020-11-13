package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entidades.Producto;
import com.example.demo.servicios.ProductoServicio;

@Controller
public class IndexController {
	
	@Autowired
	ProductoServicio productoService;

	@GetMapping({ "/", "index" })
	public ModelAndView index() {
		
		ModelAndView mav = new ModelAndView();

		List<Producto> lProducto = productoService.listarProductos();

		mav.addObject("productos", lProducto);
		mav.setViewName("index");
		return mav;

	}

}
