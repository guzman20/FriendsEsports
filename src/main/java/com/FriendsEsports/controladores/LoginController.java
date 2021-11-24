package com.FriendsEsports.controladores;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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
	public String crearUsuario(HttpServletRequest request, @RequestParam("imagen") MultipartFile imagen) {

		try {

			String nombreImagen = StringUtils.cleanPath(imagen.getOriginalFilename());

			File imagenGuardada = new File(Usuario.getImagenPath() + nombreImagen);

			String nombre = request.getParameter("nombre");
			String direccionemail = request.getParameter("email");
			String password = request.getParameter("password");
			String fecha = request.getParameter("fechaNacimiento");
			Usuario u = new Usuario(nombre, password,direccionemail, fecha, nombreImagen);
			u = usuarioServicio.crearUsuario(u);

			FileOutputStream salidaImagen = new FileOutputStream(imagenGuardada);

			BufferedOutputStream stream = new BufferedOutputStream(salidaImagen);
			stream.write(imagen.getBytes());
			stream.close();

		} catch (Exception e) {
			return "redirect:/";
		}
		return "redirect:/";
	}

}
