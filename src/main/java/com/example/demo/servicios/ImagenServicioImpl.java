package com.example.demo.servicios;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.ImagenDao;
import com.example.demo.dao.ProductoDao;
import com.example.demo.entidades.Imagen;
import com.example.demo.entidades.Producto;

@Transactional
@Service
public class ImagenServicioImpl implements ImagenServicio {

	@Autowired
	private ImagenDao imgDao;

	@Autowired
	private ProductoDao productoDao;

	public int guardarImagen(Imagen img) {
		try {
			imgDao.crear(img);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public Imagen obtenerImagen(Long id) {
		Imagen findById = imgDao.buscar(id);
		if (findById != null) {
			Imagen getImageDetails = findById;
			return findById;
		} else {
			return null;
		}
	}

	public Boolean actualizarImagen(long idProducto, MultipartFile file) {

		Producto p = productoDao.buscar(idProducto);

		Imagen img = imgDao.actualizarIamgen(p, file);

		if (img != null) {
			return true;
		} else {
			return false;
		}

	}

	


}
