package com.FriendsEsports.controladores;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.FriendsEsports.entidades.Conversacion;
import com.FriendsEsports.entidades.Juego;
import com.FriendsEsports.entidades.Usuario;
import com.FriendsEsports.servicios.ConversacionServicio;
import com.FriendsEsports.servicios.JuegoServicio;
import com.FriendsEsports.servicios.UsuarioServicio;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	JuegoServicio juegoServicio;

	@Autowired
	ConversacionServicio conversacionServicio;

	@Autowired
	UsuarioServicio usuarioServicio;

	@GetMapping("/principal")
	public ModelAndView borrarConversacion(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("admin/principal");
		return mav;

	}

	@GetMapping(value = "/crearJuego")
	public String crearJuego(@ModelAttribute("juegoObjeto") Juego juegoObjeto,HttpServletRequest request) {
		return "admin/crearJuego";

	}

	@PostMapping(value = "/crearJuego")
	public ModelAndView publicarJuego(@Valid @ModelAttribute("juegoObjeto") Juego juegoObjeto, BindingResult result,HttpServletRequest request, @RequestParam("imagen") MultipartFile imagen) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/index");
		if(result.hasErrors()) {
			return new ModelAndView("admin/crearJuego", "juegoObjeto", juegoObjeto);
		}
		try {

			String nombreImagen = StringUtils.cleanPath(imagen.getOriginalFilename());

			File imagenGuardada = new File(Juego.getImagenPath() + nombreImagen);

			String juegoNombre = request.getParameter("nombre");
			Juego juego = new Juego(juegoNombre, nombreImagen);
			juego = juegoServicio.crearJuego(juego);

			FileOutputStream salidaImagen = new FileOutputStream(imagenGuardada);

			BufferedOutputStream stream = new BufferedOutputStream(salidaImagen);
			stream.write(imagen.getBytes());
			stream.close();

			List<Conversacion> listaConversaciones = conversacionServicio.ObtenerListaPorJuegos(juego);
			List<Juego> listaJuegos = juegoServicio.listarJuegos();

			mav.addObject("juegos", listaJuegos);
			mav.addObject("juego", juego);
			mav.addObject("conversaciones", listaConversaciones);
			mav.setViewName("/juegos/vista");
		} catch (Exception e) {
			mav.setViewName("redirect:/admin/crearJuego");
			return mav;
		}
		return mav;

	}

	@RequestMapping(value = "/listaUsuarios", method = RequestMethod.GET)
	public ModelAndView listaUsuarios(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		List<Usuario> usuarios = usuarioServicio.ObtenerListaUsuarios();

		mav.addObject("usuarios", usuarios);
		mav.setViewName("admin/listaUsuarios");
		return mav;

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/borrarJuego/{idJuego}")
	public String borrarConversacion(@PathVariable("idJuego") long idJuego,
			HttpServletRequest request) {
		Juego juego = juegoServicio.obtenerPorId(idJuego);
		
		if(juegoServicio.borrarJuego(juego))
			return "redirect:/";
		else
			return "/";

	}
}
