package com.example.demo.controladores;

import org.springframework.stereotype.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entidades.Carro;
import com.example.demo.entidades.Producto;
import com.example.demo.servicios.ProductoServicio;

@Controller
@RequestMapping(value = "/compra")
public class CompraController {
	
	@Autowired
	private ProductoServicio productoServicio;
	
	@GetMapping("/carrocompra")
	public ModelAndView product(HttpSession session) {
		ModelAndView mav = new ModelAndView();

		List<Carro> listacarro = (List<Carro>) session.getAttribute("listacarro");
		

		mav.addObject("listacarro", listacarro);
		mav.setViewName("carro/carro");
		return mav;
	}
	
	@GetMapping("/add/{idProducto}")
	public String buscarProducto(HttpServletRequest request, @PathVariable("idProducto") long idProducto) {

		// Se recoge la cantidad del producto
		Integer cantidadproducto = 1;//Integer.parseInt(request.getParameter("cantidadproducto"));

		// Crea carrito con el producto
		Carro carro = new Carro(productoServicio.obtenerProducto(idProducto), cantidadproducto);

		//Meter el carrito en lista
		List<Carro> listcarro = (List<Carro>) request.getSession().getAttribute("listacarro");
		listcarro.add(carro);
		request.getSession().setAttribute("listcarro", listcarro);

		return "redirect:/index";
	}

}
