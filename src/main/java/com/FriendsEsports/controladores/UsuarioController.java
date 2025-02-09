package com.FriendsEsports.controladores;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.FriendsEsports.entidades.Conversacion;
import com.FriendsEsports.entidades.ConversacionDTO;
import com.FriendsEsports.entidades.RespuestaDTO;
import com.FriendsEsports.entidades.Usuario;
import com.FriendsEsports.entidades.UsuarioDTO;
import com.FriendsEsports.servicios.ConversacionServicio;
import com.FriendsEsports.servicios.UsuarioServicio;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	UsuarioServicio usuarioServicio;

	@Autowired
	ConversacionServicio conversacionServicio;

	@PostMapping("/logueado")
	public String Loguearse(@RequestParam(value = "nombre") String nombre,
			@RequestParam(value = "password") String password, HttpServletRequest request, HttpSession session)
			throws IOException {
		if (usuarioServicio.logIn(nombre, password)) {
			session.setAttribute("nombre", nombre);
			Usuario usuario = new Usuario();
			usuario = usuarioServicio.buscarUsuario(nombre);
			session.setAttribute("idUsuario", usuario.getIdUsuario());
			session.setAttribute("imagenUsuario", usuario.getImagen());
			return "redirect:/index";
		} else
			return "redirect:/usuario/login";
	}

	@GetMapping("/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}

	@GetMapping("/perfil/{idUsuario}")
	public ModelAndView verPerfil(HttpServletRequest request, @PathVariable("idUsuario") long idUsuario, Model modelo) {

		ModelAndView mav = new ModelAndView();
		if (modelo.containsAttribute("org.springframework.validation.BindingResult.usuarioEditar"))
			mav.addObject("org.springframework.validation.BindingResult.usuarioEditar",
					modelo.getAttribute("org.springframework.validation.BindingResult.usuarioEditar"));
		else {
			mav.addObject("usuarioEditar", new UsuarioDTO());
		}

		Usuario usuario = new Usuario();
		usuario = usuarioServicio.buscarUsuario(idUsuario);
		mav.addObject("usuario", usuario);
		mav.setViewName("usuario/perfil");
		return mav;

	}

	@GetMapping("/borrar/{idUsuario}")
	public String borrarUsuario(HttpSession session, @PathVariable("idUsuario") long idUsuario,
			HttpServletRequest request) {
		long idSesion = (long) session.getAttribute("idUsuario");
		Usuario usuario = usuarioServicio.buscarUsuario(idSesion);
		if (usuario.getRoles().stream().anyMatch(rol -> rol.getNombreRol().equals("rolAdmin")) || idSesion == idUsuario)
			usuarioServicio.eliminarUsuario(idUsuario);
		if (session.getAttribute("idUsuario").equals(idUsuario))
			session.invalidate();
		return "redirect:/admin/listaUsuarios";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/editar")
	public ModelAndView editarConversacion(HttpServletRequest request, HttpSession session,
			@Valid @ModelAttribute("usuarioEditar") UsuarioDTO usuarioEditar, BindingResult result,
			RedirectAttributes atributos) {

		if (result.hasErrors()) {
			atributos.addFlashAttribute("org.springframework.validation.BindingResult.usuarioEditar", result);
			atributos.addFlashAttribute("usuarioEditar", usuarioEditar);
		}

		String antiguaPassword = request.getParameter("antiguaPassword");
		long idUsuario = (long) session.getAttribute("idUsuario");
		Usuario antiguoUsuario = usuarioServicio.buscarUsuario(idUsuario);

		if (usuarioServicio.verificarIdentidad(antiguaPassword, antiguoUsuario.getNombre())) {
			String nombre = request.getParameter("nombre");
			if (nombre.equals("") || nombre == null)
				nombre = antiguoUsuario.getNombre();

			String email = request.getParameter("email");
			if (email.equals("") || email == null)
				email = antiguoUsuario.getEmail();

			String fechaNacimiento = request.getParameter("fechaNacimiento");
			if (fechaNacimiento.equals("") || fechaNacimiento == null)
				fechaNacimiento = antiguoUsuario.getFechaNacimiento();
			
			

			String nuevaPassword = request.getParameter("nuevaPassword");
			if (nuevaPassword.equals("") || nuevaPassword == null) {
				antiguoUsuario.setNombre(nombre);
				antiguoUsuario.setEmail(email);
				antiguoUsuario.setFechaNacimiento(fechaNacimiento);
				usuarioServicio.editarUsuario(antiguoUsuario);
			} else {
				Usuario usuarioNuevo = new Usuario(idUsuario, nombre, nuevaPassword, email, fechaNacimiento,
						antiguoUsuario.getImagen());
				usuarioServicio.editarUsuario(usuarioNuevo);
			}
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/usuario/perfil/" + idUsuario);
		return mav;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/listaConversaciones/{idUsuario}")
	public ModelAndView historialConversaciones(@ModelAttribute("conversacion") ConversacionDTO conversacionDTO,
			@PathVariable("idUsuario") long idUsuario, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		Usuario u = usuarioServicio.buscarUsuario(idUsuario);
		List<Conversacion> conversaciones = conversacionServicio.ObtenerListaPorUsuario(u);

		mav.addObject("conversaciones", conversaciones);
		mav.setViewName("usuario/historialConversaciones");
		return mav;

	}
}