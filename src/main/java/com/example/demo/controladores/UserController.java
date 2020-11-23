package com.example.demo.controladores;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entidades.User;
import com.example.demo.servicios.UserServicio;


@Controller
@RequestMapping(value = "/Usuario")
public class UserController {
	
	@Autowired
	UserServicio userServicio;

	@PostMapping("/signIn")
	public String crearProducto(@RequestParam(value="nombre",required=false) String nombre,
								@RequestParam(value="apellidos",required=false) String apellidos,
								@RequestParam(value="password",required=false) String password,
								@RequestParam(value="email",required=false) String email,
								@RequestParam(value="fechaNacimiento",required=false) String fechaNacimiento,
								@RequestParam(value="numeroTarjeta",required=false) Integer numeroTarjeta,
								@RequestParam(value="titularTarjeta",required=false) String titularTarjeta,
								@RequestParam(value="codigoSeguridad",required=false) Integer codigoSeguridad,
								@RequestParam(value="direccionFacturacion",required=false) String direccionFacturacion,
								HttpServletRequest request) throws IOException {
		
		User u= new User(nombre,apellidos,password,email,fechaNacimiento,numeroTarjeta,titularTarjeta,codigoSeguridad,direccionFacturacion);
		
		User usuario=userServicio.crearUsuario(u);

		return "redirect:/index";
		}

	
	@GetMapping("/registro")
	public String showFormReg() {
		return "user/registro";
	}
	
	@GetMapping("/login")
	public String showFormLog() {
		return "user/login";
	}
}
