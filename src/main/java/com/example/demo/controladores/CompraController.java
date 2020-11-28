package com.example.demo.controladores;

import org.springframework.stereotype.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.entidades.Carro;
import com.example.demo.servicios.ProductoServicio;

@Controller
@RequestMapping(value = "/compra")
public class CompraController {
	
	@Autowired
	private ProductoServicio productoServicio;
	
	@GetMapping("/carrocompra")
	public String product(Model model, HttpSession session) {

		// Se recoge la lista de carritos de la session	
		List<Carro> listacarritos = (List<Carro>) session.getAttribute("listacarritos");
		

		// Añadimos la lista al modelo
		model.addAttribute("listacarritos", listacarritos);
		return "carro";
	}

}
