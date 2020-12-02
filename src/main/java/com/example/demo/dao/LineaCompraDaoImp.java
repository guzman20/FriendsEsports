package com.example.demo.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.LineaCompra;
import com.example.demo.entidades.User;

@Repository
@Component("LineaCompraDao")
public class LineaCompraDaoImp extends DaoGenericoImp<LineaCompra> implements LineaCompraDao {

	@Override
	public List<LineaCompra> buscarComprasPorIdCompra(User usuario) {
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
