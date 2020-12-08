package com.tiendavirtual.service;

import java.util.List;

import com.tiendavirtual.model.Categoria;

public interface ICategoriaService extends ICRUD<Categoria, Integer>{
	
	List<Categoria> listar(Integer idLinea);

}
