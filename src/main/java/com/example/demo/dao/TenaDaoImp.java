package com.example.demo.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.example.demo.entidades.Tema;

@Repository
@Component("Tema")
public class TenaDaoImp extends DaoGenericoImp<Tema> implements TemaDao {

	
}
