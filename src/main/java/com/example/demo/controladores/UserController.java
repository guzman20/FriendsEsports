package com.example.demo.controladores;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@GetMapping("/registro")
	public String showFormReg() {
		return "user/registro";
	}
	
	@GetMapping("/login")
	public String showFormLog() {
		return "user/login";
	}

}
