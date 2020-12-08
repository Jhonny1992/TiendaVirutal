package com.tiendavirtual.service;

import java.util.List;

import com.tiendavirtual.model.Familia;

public interface IFamiliaService extends ICRUD<Familia, Integer>{
	
	List<Familia> listar(Integer idCategoria);

}
