package com.FriendsEsports.controladores;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.FriendsEsports.entidades.Usuario;
import com.FriendsEsports.servicios.UsuarioServicio;

@Controller
@RequestMapping(value = "/user")
public class UsuarioController {

	@Autowired
	UsuarioServicio usuarioServicio;

	@PostMapping("/logueado")
	public String Loguearse(@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "password", required = false) String password, HttpServletRequest request,
			HttpSession session) throws IOException {

		if (usuarioServicio.logIn(nombre, password)) {
			session.setAttribute("nombre", nombre);
			Usuario usuario = new Usuario();
			usuario = usuarioServicio.buscarUsuario(nombre);
			session.setAttribute("idUsuario", usuario.getIdUsuarios());
			return "redirect:/index";
		} else
			return "redirect:/user/login";
	}

	@GetMapping("/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}

	@GetMapping("/perfil")
	public ModelAndView verPerfil(HttpServletRequest request) {
		Usuario usuario = new Usuario();
		ModelAndView mav = new ModelAndView();
		long id = (long) request.getSession().getAttribute("idUsuario");
		usuario = usuarioServicio.obtenerUsuario(id);
		mav.addObject("usuario", usuario);
		mav.setViewName("user/perfil");
		return mav;

	}
}