package com.tiendavirtual.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendavirtual.model.Clase;
import com.tiendavirtual.model.Familia;
import com.tiendavirtual.model.Producto;
import com.tiendavirtual.repo.IGenericRepo;
import com.tiendavirtual.repo.IProductoRepo;
import com.tiendavirtual.service.IProductoService;

@Service
public class ProductoServiceImpl extends CRUDImpl<Producto, Integer> implements IProductoService {

	@Autowired
	private IProductoRepo repo;
	
	@Override
	protected IGenericRepo<Producto, Integer> getRepo() {
		return repo;
	}

	@Transactional
	@Override
	public List<Producto> listaProductoLCFC() {
		List<Producto> consultas = new ArrayList<>();
		repo.listarProductosLCFC().forEach(x -> {
			Producto cr = new Producto();
			cr.setIdProducto(Integer.parseInt(String.valueOf(x[0])));
			cr.setCodigoProducto(String.valueOf(x[1]));
			cr.setNombreProducto(String.valueOf(x[2]));
			cr.setDescripcionProducto(String.valueOf(x[3]));
			cr.setPrecioProducto(Double.parseDouble(String.valueOf(x[4])));
			
			Clase cl=new Clase();
			cl.setDescripClase(String.valueOf(x[5]));
			cr.setClase(cl);
			
			Familia fa=new Familia();
			fa.setDescripFamilia(String.valueOf(x[6]));
			cl.setFamilia(fa);
			
			consultas.add(cr);
		});
		
		return consultas;
	}
}
