package com.tiendavirtual.service;

import java.util.List;

import com.tiendavirtual.model.Producto;

public interface IProductoService extends ICRUD<Producto, Integer> {
	
	List<Producto> listaProductoLCFC();

}
