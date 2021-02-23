package com.example.demo.dao;

import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entidades.Imagen;
import com.example.demo.entidades.Producto;

@Repository
@Component("ImagenDao")
public class ImagenDaoImpl  extends DaoGenericoImp<Imagen> implements ImagenDao{

	@Override
	public Imagen actualizarIamgen(Producto producto, MultipartFile file) {
		try {
			byte[] image = file.getBytes();

			if (!producto.getImagen().isEmpty()) {

				Set<Imagen> limg = producto.getImagen();

				for (Imagen a : limg) {
					a.setImagen(image);
					this.em.merge(a);
					this.em.refresh(a);
					return a;
				}
				return null;
				
			} else {
				Imagen img = new Imagen("foto", image);
				producto.addImagen(img);
				this.em.persist(img);
				this.em.merge(producto);
				return img;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
