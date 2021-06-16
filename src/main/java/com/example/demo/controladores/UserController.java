package com.example.demo.controladores;

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

import com.example.demo.entidades.User;
import com.example.demo.servicios.UserServicio;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserServicio userServicio;

	@PostMapping("/logueado")
	public String Loguearse(@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "password", required = false) String password, HttpServletRequest request,
			HttpSession session) throws IOException {

		if (userServicio.logIn(nombre, password)) {
			session.setAttribute("nombre", nombre);
			User usuario = new User();
			usuario = userServicio.buscarUsuario(nombre);
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
		User usuario = new User();
		ModelAndView mav = new ModelAndView();
		long id = (long) request.getSession().getAttribute("idUsuario");
		usuario = userServicio.obtenerUsuario(id);
		mav.addObject("usuario", usuario);
		mav.setViewName("user/perfil");
		return mav;

	}
}