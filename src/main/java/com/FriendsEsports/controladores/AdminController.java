package com.FriendsEsports.controladores;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.FriendsEsports.entidades.Conversacion;
import com.FriendsEsports.entidades.Juego;
import com.FriendsEsports.servicios.ConversacionServicio;
import com.FriendsEsports.servicios.JuegoServicio;


@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	JuegoServicio juegoServicio;
	
	@Autowired
	ConversacionServicio conversacionServicio;

	@GetMapping("/principal")
	public ModelAndView borrarConversacion(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("admin/principal");
		return mav;

	}
	
	@RequestMapping(value = "/crearJuego", method = RequestMethod.GET)
	public ModelAndView crearConversacion(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/crearJuego");
		return mav;

	}
	
	@RequestMapping(value = "/creadoJuego", method = RequestMethod.POST)
	public ModelAndView publicarJuego(HttpServletRequest request, @RequestParam("imagen") MultipartFile imagen) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/index");
		try {
			
			String nombreImagen = StringUtils.cleanPath(imagen.getOriginalFilename());
	        
	        File imagenGuardada =new File("src/main/resources/static/imagenes-juegos/"+nombreImagen);
	        
	        String juegoNombre = request.getParameter("nombre");
			Juego juego = new Juego(juegoNombre, imagenGuardada.getPath());
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
			return mav;
		}
		return mav;

	}
}
