package com.example.demo.dao;


import java.util.HashSet;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.mapping.Set;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Compra;
import com.example.demo.entidades.LineaCompra;
import com.example.demo.entidades.Producto;
import com.example.demo.entidades.User;

@Repository
@Component("CompraDao")
public class CompraDaoImp extends DaoGenericoImp<Compra> implements CompraDao {

	@Override
	public Compra addLineaCompra(Compra compra, LineaCompra lineaCompra) {
		compra.getProductos().add(lineaCompra);
		return compra;
	}

	@Override
	public List<Compra> comprasUsuario(User usuario) {
		Query query = this.em.createQuery("select lc, p FROM LineaCompra as lc"
				+ " inner join lc.compra as c "
				+ " inner join lc.producto as p"
				+  " where c.user = :usuario");
		query.setParameter("usuario", usuario);
		List<LineaCompra> lineaCompra = query.getResultList();

		if (lineaCompra != null) {
			return lineaCompra;
		}
		return null;
	}

}
