package com.example.demo.dao;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entidades.Imagen;
import com.example.demo.entidades.Producto;

@Repository
public interface ImagenDao extends DaoGenerico<Imagen>{
	public Imagen actualizarIamgen(Producto producto, MultipartFile file);
}
