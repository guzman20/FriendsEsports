package com.example.demo.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.LineaCompra;

@Repository
@Component("LineaCompraDao")
public class LineaCompraDaoImp extends DaoGenericoImp<LineaCompra> implements LineaCompraDao {

}
