package com.FriendsEsports.controladores;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.FriendsEsports.entidades.Conversacion;
import com.FriendsEsports.entidades.Juego;
import com.FriendsEsports.entidades.Usuario;
import com.FriendsEsports.entidades.UsuarioDTO;
import com.FriendsEsports.servicios.UsuarioServicio;

@Controller
public class LoginController {

	@Autowired
	UsuarioServicio usuarioServicio;

	@GetMapping("/login")
	public String login() {
		return "auth/login";
	}

	@GetMapping("/login-error")
	public String login(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		String mensajeError = null;
		if (session != null) {
			AuthenticationException ex = (AuthenticationException) session
					.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
			if (ex != null) {
				mensajeError = "El usuario o contraseña introducidos son incorrectos";
			}
		}
		model.addAttribute("mensajeError", mensajeError);
		return "auth/login";
	}

	@PostMapping("/crearUsuario")
	public String createUser(@ModelAttribute("usuario") Usuario elUsuario) {
		Usuario usuario = usuarioServicio.crearUsuario(elUsuario);

		return "redirect:/login";
	}

	@GetMapping("/registro")
	public String showForm(@ModelAttribute("usuario") UsuarioDTO usuario) {
		return "auth/registro";
	}

	@PostMapping("/signup")
	public String crearUsuario(@Valid @ModelAttribute("usuario") UsuarioDTO usuario, BindingResult result,
			HttpServletRequest request, @RequestParam("imagen") MultipartFile imagen) {

		if (result.hasErrors()) {
			return "auth/registro";
		}

		try {
			if (!imagen.getOriginalFilename().equals("")) {

				String nombreImagen = StringUtils.cleanPath(imagen.getOriginalFilename());

				File imagenGuardada = new File(Usuario.getImagenPath() + nombreImagen);

				String nombre = request.getParameter("nombre");
				String direccionemail = request.getParameter("email");
				String password = request.getParameter("nuevaPassword");
				String fecha = request.getParameter("fechaNacimiento");
				Usuario u = new Usuario(nombre, password, direccionemail, fecha, nombreImagen);
				u = usuarioServicio.crearUsuario(u);

				FileOutputStream salidaImagen = new FileOutputStream(imagenGuardada);

				BufferedOutputStream stream = new BufferedOutputStream(salidaImagen);
				stream.write(imagen.getBytes());
				stream.close();
			} else {

				String nombre = request.getParameter("nombre");
				String direccionemail = request.getParameter("email");
				String password = request.getParameter("nuevaPassword");
				String fecha = request.getParameter("fechaNacimiento");
				Usuario u = new Usuario(nombre, password, direccionemail, fecha);
				u = usuarioServicio.crearUsuario(u);
			}

		} catch (Exception e) {
			return "redirect:/";
		}
		return "redirect:/login";
	}

}
