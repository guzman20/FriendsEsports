package com.example.demo.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entidades.Tema;
import com.example.demo.entidades.TemaDTO;
import com.example.demo.entidades.User;
import com.example.demo.servicios.TemaServicio;
import com.example.demo.servicios.UserServicio;
import com.fasterxml.jackson.databind.JsonNode;

@Controller
@RequestMapping(value = "/tema")
public class TemaController {

	@Autowired
	TemaServicio temaServicio;

	@Autowired
	UserServicio userServicio;

	@RequestMapping(value = "/crear", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public TemaDTO publicartema(@RequestBody JsonNode values, HttpServletRequest request) {

		String texto = values.findValue("temaTexto").asText();

		if (texto != "") {

			Tema tema = new Tema();
			Long idUsuario = (long) request.getSession().getAttribute("idUsuario");
			User usuario = (User) userServicio.obtenerUsuario(idUsuario);
			tema = temaServicio.crearTema(usuario, texto);

			return temaServicio.conversionDTO(tema);

		} else

			return null;

	}

	@RequestMapping(value = "/borrar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Long borrartema(@RequestBody JsonNode values, HttpServletRequest request) {

		Long idtema = values.findValue("idtema").asLong();

		temaServicio.borrarTema(idtema);
		return idtema;

	}

	@RequestMapping(value = "/editar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public TemaDTO editartema(@RequestBody JsonNode values, HttpServletRequest request) {

		Long idtema = values.findValue("idtema").asLong();
		String tema = values.findValue("tema").asText();

		TemaDTO temaDTO = temaServicio
				.conversionDTO(temaServicio.editarTema(idtema, tema));

		return temaDTO;

	}

}
