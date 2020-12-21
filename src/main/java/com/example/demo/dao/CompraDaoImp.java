package com.example.demo.dao;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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

	public List<Compra> comprasUsuarios(User usuario){
		List<Compra> listaCompra = new ArrayList<>();
		
		Iterator<?> value = usuario.getProductos().iterator(); 
		  
        while (value.hasNext()) { 
            listaCompra.add((Compra) value.next());
        }
		return listaCompra;
	}
}
