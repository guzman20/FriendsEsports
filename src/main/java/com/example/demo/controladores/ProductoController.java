package com.example.demo.controladores;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entidades.Producto;
import com.example.demo.servicios.ProductoServicio;

@Controller
@RequestMapping(value = "/producto")
public class ProductoController {
	
	@Autowired
	ProductoServicio productoServicio;
	
	@RequestMapping(method = RequestMethod.GET, value = "/idProducto/{id}")
	public ModelAndView descripcionProducto(@PathVariable("id") long idProducto, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		Producto producto = productoServicio.obtenerProducto(idProducto);
		Boolean propietario = false;

		if (request.getSession().getAttribute("idUsuario") != null) {
			long idSession = (long) request.getSession().getAttribute("idUsuario");
			propietario = idSession == idProducto;
		}

		mav.addObject("propietario", propietario);
		mav.addObject("producto", producto);
		mav.setViewName("producto/idProducto");
		return mav;
	}
	
	@GetMapping("/crear")
	public String showForm() {
		return "producto/crear";
	}
	
	@PostMapping("/crear")
	public String crearUsuario(@RequestParam("imagen") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
		
		
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
//		String imagen = request.getParameter("imagen");

		Producto p = new Producto();
		p.setNombre(nombre);
		p.setDescripcion(descripcion);
		
		
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		
		p.setImagen(fileName);
		
        // save the file on the local file system
        try {
            Path path = Paths.get("src/main/resources/static/images/" + fileName);
            Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }  

		Producto product = productoServicio.crearProducto(p);

		return "redirect:/index";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/borrar/{idProducto}")
	public String borrarProducto(@PathVariable("idProducto") long idProducto) {
		
		productoServicio.eliminarProducto(idProducto);

		return "redirect:/index";
	}
	

}
