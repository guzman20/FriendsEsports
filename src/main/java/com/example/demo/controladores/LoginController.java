package com.example.demo.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entidades.User;
import com.example.demo.servicios.UserServicio;

@Controller
public class LoginController {
	
	@Autowired
	UserServicio userServicio;
	
	//Página de login custom
	@GetMapping("/login")
	public String login() {
		return "auth/login";
	}

//	@GetMapping("/access-denied")
//	public String accessDenied() {
//		return "/error/access-denied";
//	}
//
	@PostMapping("/crearUsuario")
	public String createUser(@ModelAttribute("usuario") User elUsuario) {
		User usuario = userServicio.crearUsuario(elUsuario);

		return "redirect:/index";
	}

	@GetMapping("/registro")
	public String showForm() {
		return "auth/registro";
	}
	
	@GetMapping("/signup")
	public String showForm2() {
		return "auth/registro";
	}
	
	

	//No quiere funcionar SOLUCIONAR
	@PostMapping("/signup")
	public String crearUsuario(HttpServletRequest request) {

		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String direccionemail = request.getParameter("email");
		String password = request.getParameter("password");
		
		User u = new User();
		u.setNombre(nombre);
		u.setApellidos(apellidos);;
		u.setPassword(password);
		u.setEmail(direccionemail);
		System.out.println(u.toString());
		userServicio.crearUsuario(u);
		

		return "redirect:/";
	}


}
