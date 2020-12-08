package com.tiendavirtual.service;

import java.util.List;

import com.tiendavirtual.model.Clase;

public interface IClaseService extends ICRUD<Clase, Integer>{
	
	List<Clase> listar(Integer idFamilia);

}
