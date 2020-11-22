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

		mav.addObject("producto", producto);
		mav.setViewName("producto/idProducto");
		return mav;
	}
	
	@GetMapping("/crear")
	public String showForm() {
		return "producto/crear";
	}
	
	@PostMapping("/crear")
	public String crearProducto(@RequestParam("imagen") MultipartFile multipartFile,
								@RequestParam(value="nombre",required=false) String nombre,
								@RequestParam(value="descripcion",required=false) String descripcion,
								@RequestParam(value="precio",required=false) Double precio,
								@RequestParam(value="descuento",required=false) Integer descuento
								, HttpServletRequest request) throws IOException {
		if(descuento==null) {
			
		}
		
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		Producto p = new Producto(nombre,descripcion,fileName,precio,descuento);
		
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

		return "redirect:/";
	}
	

}
