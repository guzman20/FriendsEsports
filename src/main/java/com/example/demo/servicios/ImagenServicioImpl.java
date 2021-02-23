package com.example.demo.servicios;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
		File fi = null;
		byte[] convertir = null;
		Imagen findById = imgDao.buscar(id);
		if (findById != null) {
			Imagen getImageDetails = findById;
			return findById;
		} else {
			fi = new File("src/main/resources/static/images/producto.jpg");
			try {
				convertir  = Files.readAllBytes(fi.toPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Imagen getImageDetails = new Imagen("",convertir);
			return getImageDetails;
			
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
