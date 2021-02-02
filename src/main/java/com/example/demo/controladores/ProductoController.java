package com.example.demo.controladores;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entidades.Pregunta;
import com.example.demo.entidades.Producto;
import com.example.demo.servicios.PreguntasServicio;
import com.example.demo.servicios.ProductoServicio;

@Controller
@RequestMapping(value = "/producto")
public class ProductoController {

	@Autowired
	ProductoServicio productoServicio;
	
	@Autowired
	PreguntasServicio preguntasServicio;

	@RequestMapping(method = RequestMethod.GET, value = "/idProducto/{id}")
	public ModelAndView descripcionProducto(@PathVariable("id") long idProducto, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		Producto producto = productoServicio.obtenerProducto(idProducto);
		List<Pregunta> preguntas= preguntasServicio.listarPreguntas(producto);
		
		mav.addObject("Preguntas", preguntas);
		mav.addObject("logIn", request.getAttribute("logIn"));
		mav.addObject("producto", producto);
		mav.setViewName("producto/idProducto");
		return mav;
	}

	@GetMapping("/crear")
	public ModelAndView showForm(Model model, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		mav.addObject("logIn", request.getAttribute("logIn"));
		mav.setViewName("producto/crear");

		return mav;
	}

	@PostMapping("/crear")
	public ModelAndView crearProducto(@RequestParam("imagen") MultipartFile multipartFile,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "descripcion", required = false) String descripcion,
			@RequestParam(value = "precio", required = false) Double precio,
			@RequestParam(value = "descuento", required = false) Integer descuento, HttpServletRequest request)
			throws IOException {
		ModelAndView mav = new ModelAndView();

		if (descuento == null) {
			descuento = 0;
		}
		if (nombre.isEmpty() || nombre.isBlank() || nombre == null || descripcion.isEmpty() || descripcion.isBlank()
				|| descripcion == null || precio == null) {

			mav.addObject("error", "Todos los campos son obligatorios. Por favor rellénelos.");
			mav.setViewName("producto/crear");

			return mav;
		}
		String fileName;
		if (multipartFile != null) {

			fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

			// save the file on the local file system
			try {
				Path path = Paths.get("src/main/resources/static/images/" + fileName);
				Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			fileName = null;
		}

		Producto p = new Producto(nombre, descripcion, fileName, precio, descuento);

		Producto product = productoServicio.crearProducto(p);

		mav.addObject("logIn", request.getAttribute("logIn"));
		mav.setViewName("redirect:/");

		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/borrar/{idProducto}")
	public ModelAndView borrarProducto(@PathVariable("idProducto") long idProducto, HttpServletRequest request) {

		productoServicio.eliminarProducto(idProducto);

		ModelAndView mav = new ModelAndView();

		mav.addObject("logIn", request.getAttribute("logIn"));
		mav.setViewName("redirect:/");

		return mav;
	}

}
