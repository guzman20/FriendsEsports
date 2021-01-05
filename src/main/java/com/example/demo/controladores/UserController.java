package com.example.demo.controladores;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entidades.Carro;
import com.example.demo.entidades.Producto;
import com.example.demo.entidades.User;
import com.example.demo.servicios.UserServicio;


@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	UserServicio userServicio;

	@PostMapping("/registrado")
	public String Registrarse(@RequestParam(value="nombre",required=false) String nombre,
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
	
	@PostMapping("/logueado")
	public String Loguearse(@RequestParam(value="nombre",required=false) String nombre,
								@RequestParam(value="password",required=false) String password,
								HttpServletRequest request, HttpSession session) throws IOException {
		
		if(userServicio.logIn(nombre, password)) {
			List<Carro> listacarro = new ArrayList<Carro>();
			session.setAttribute("listacarro", listacarro);
			session.setAttribute("nombre", nombre);
			User usuario= new User();
			usuario=userServicio.buscarUsuario(nombre);
			session.setAttribute("idUsuario", usuario.getIdUsuarios());
			return "redirect:/index";
		}
		else
			return "redirect:/user/login";
		}
	
	@GetMapping("/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}
	
	//Ahora estos dos van en LoginController
//	@GetMapping("/registro")
//	public String showFormReg() {
//		return "user/registro";
//	}
//	
//	@GetMapping("/login")
//	public String showFormLog() {
//		return "user/login";
//	}
	
	@GetMapping("/perfil")
	public ModelAndView verPerfil(HttpServletRequest request){
		User usuario=new User();
		ModelAndView mav = new ModelAndView();
		long id=(long) request.getSession().getAttribute("idUsuario");
		usuario=userServicio.obtenerUsuario(id);

		

		mav.addObject("usuario", usuario);
		mav.setViewName("user/perfil");
		return mav;
		
	}
}