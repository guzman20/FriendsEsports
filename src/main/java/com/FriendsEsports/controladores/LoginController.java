package com.FriendsEsports.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.FriendsEsports.entidades.Usuario;
import com.FriendsEsports.servicios.UsuarioServicio;

@Controller
public class LoginController {
	
	@Autowired
	UsuarioServicio usuarioServicio;
	
	@GetMapping("/login")
	public String login() {
		return "auth/login";
	}

	@PostMapping("/crearUsuario")
	public String createUser(@ModelAttribute("usuario") Usuario elUsuario) {
		Usuario usuario = usuarioServicio.crearUsuario(elUsuario);

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
	
	

	@PostMapping("/signup")
	public String crearUsuario(HttpServletRequest request) {

		String nombre = request.getParameter("nombre");
		String direccionemail = request.getParameter("email");
		String password = request.getParameter("password");
		String fecha = request.getParameter("fechaNacimiento");
		
		Usuario u = new Usuario();
		u.setNombre(nombre);
		u.setPassword(password);
		u.setEmail(direccionemail);
		u.setFecha_Nacimiento(fecha);
		usuarioServicio.crearUsuario(u);
		

		return "redirect:/";
	}


}
