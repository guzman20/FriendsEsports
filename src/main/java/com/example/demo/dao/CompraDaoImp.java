package com.example.demo.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Compra;
import com.example.demo.entidades.Producto;
import com.example.demo.entidades.User;

@Repository
@Component("CompraDao")
public class CompraDaoImp extends DaoGenericoImp<Compra> implements CompraDao {

}
