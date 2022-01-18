package com.FriendsEsports.controladores;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
import com.FriendsEsports.entidades.ConversacionDTO;
import com.FriendsEsports.entidades.Juego;
import com.FriendsEsports.entidades.Respuesta;
import com.FriendsEsports.entidades.RespuestaDTO;
import com.FriendsEsports.entidades.Usuario;
import com.FriendsEsports.servicios.ConversacionServicio;
import com.FriendsEsports.servicios.JuegoServicio;
import com.FriendsEsports.servicios.RespuestaServicio;
import com.FriendsEsports.servicios.UsuarioServicio;

@Controller
@RequestMapping(value = "/conversacion")
public class ConversacionController {

	@Autowired
	ConversacionServicio conversacionServicio;

	@Autowired
	UsuarioServicio usuarioServicio;

	@Autowired
	RespuestaServicio respuestaServicio;

	@Autowired
	JuegoServicio juegoServicio;

	@PostMapping(value = "/crear")
	public ModelAndView crearConversacion(@ModelAttribute("conversacion") ConversacionDTO ConversacionDTO,
			HttpServletRequest request, @RequestParam("juego") String juego) {

		ModelAndView mav = new ModelAndView("conversacion/crear", "conversacion", ConversacionDTO);

		mav.addObject("juego", juego);
		return mav;

	}

	@PostMapping(value = "/creado")
	public ModelAndView publicarConversacion(@Valid @ModelAttribute("conversacion") ConversacionDTO ConversacionDTO,
			BindingResult result, HttpServletRequest request, @RequestParam("imagen") MultipartFile imagen,
			@RequestParam("juego") String idj) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/index");
		if (result.hasErrors()) {
			mav = new ModelAndView("conversacion/crear", "conversacion", ConversacionDTO);
			List<Juego> juegos = juegoServicio.listarJuegos();

			mav.addObject("juegos", juegos);
		}
		try {
			long idJuego = Integer.parseInt(idj);
			Juego juego = juegoServicio.obtenerPorId(idJuego);
			if (juego != null) {

				String titulo = ConversacionDTO.getTitulo();
				String texto = ConversacionDTO.getTexto();
				long id = (long) request.getSession().getAttribute("idUsuario");
				Usuario usuario = (Usuario) usuarioServicio.buscarUsuario(id);

				Conversacion t = new Conversacion();

				if (imagen.getOriginalFilename().length() != 0) {
					String nombreImagen = StringUtils.cleanPath(imagen.getOriginalFilename());

					File imagenGuardada = new File(Conversacion.getImagenPath() + nombreImagen);

					FileOutputStream salidaImagen = new FileOutputStream(imagenGuardada);

					BufferedOutputStream stream = new BufferedOutputStream(salidaImagen);
					stream.write(imagen.getBytes());
					stream.close();

					t = new Conversacion(juego, texto, titulo, usuario, nombreImagen);
				} else
					t = new Conversacion(juego, texto, titulo, usuario);

				conversacionServicio.crearConversacion(t);

				mav.setViewName("redirect:/conversacion/" + t.getIdConversacion());
			} else {
				mav.setViewName("redirect:/conversacion/crear");
			}
		} catch (Exception e) {
			return mav;
		}
		return mav;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/borrar/{idConversacion}")
	public ModelAndView borrarConversacion(@PathVariable("idConversacion") long idConversacion,
			HttpServletRequest request) {
		Conversacion c = conversacionServicio.obtenerConversacion(idConversacion);

		conversacionServicio.borrarConversacion(idConversacion);

		ModelAndView mav = new ModelAndView();

		mav.setViewName("redirect:/juegos/" + c.getJuego().getIdJuego());
		return mav;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/editar/{idConversacion}")
	public ModelAndView editarConversacion(@PathVariable("idConversacion") long idConversacion,
			@RequestParam("imagen") MultipartFile imagen, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/index");
		try {
			String titulo = request.getParameter("titulo");
			String texto = request.getParameter("texto");

			if (imagen.getSize() != 0) {
				String nombreImagen = StringUtils.cleanPath(imagen.getOriginalFilename());

				File imagenGuardada = new File(Conversacion.getImagenPath() + nombreImagen);

				FileOutputStream salidaImagen = new FileOutputStream(imagenGuardada);

				BufferedOutputStream stream = new BufferedOutputStream(salidaImagen);
				stream.write(imagen.getBytes());
				stream.close();

				Conversacion c = conversacionServicio.obtenerConversacion(idConversacion);
				File imagenOriginal = new File(Conversacion.getImagenPath() + c.getImagen());
				imagenOriginal.delete();

				conversacionServicio.editarConversacion(idConversacion, titulo, texto, nombreImagen);
			} else
				conversacionServicio.editarConversacion(idConversacion, titulo, texto);

			mav.setViewName("redirect:/conversacion/" + idConversacion);
			return mav;
		} catch (Exception e) {
			return mav;
		}

	}

	@RequestMapping(method = RequestMethod.GET, value = "/{idConversacion}")
	public ModelAndView verConversacion(@ModelAttribute("respuesta") RespuestaDTO respuestaDTO,
			@PathVariable("idConversacion") long idConversacion, HttpServletRequest request, ModelAndView mav) {

		Conversacion c = conversacionServicio.obtenerConversacion(idConversacion);
		List<Respuesta> r = respuestaServicio.listarRespuestas(c);
		List<Juego> listaJuegos = juegoServicio.listarJuegos();
		if (!mav.getModel().containsKey("respuesta"))
			mav.addObject("respuesta", new RespuestaDTO());

		mav.addObject("juegos", listaJuegos);
		mav.addObject("conversacion", c);
		mav.addObject("respuestas", r);

		mav.setViewName("conversacion/conversacion");
		return mav;

	}

}
