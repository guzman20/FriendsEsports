package com.example.demo.servicios;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entidades.Imagen;

public interface ImagenServicio {
	
	public int guardarImagen(Imagen img);
	
	public Imagen obtenerImagen(Long id);
	
	public Boolean actualizarImagen(long idProfesor, MultipartFile file);

}
