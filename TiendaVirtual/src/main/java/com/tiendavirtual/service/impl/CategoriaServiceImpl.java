package com.tiendavirtual.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendavirtual.model.Categoria;
import com.tiendavirtual.repo.ICategoriaRepo;
import com.tiendavirtual.repo.IGenericRepo;
import com.tiendavirtual.service.ICategoriaService;

@Service
public class CategoriaServiceImpl extends CRUDImpl<Categoria, Integer> implements ICategoriaService{

	@Autowired
	private ICategoriaRepo repo;
	
	@Transactional
	@Override
	public List<Categoria> listar(Integer idLinea) {
		return repo.listaCategoriaPorLinea(idLinea);
	}

	@Override
	protected IGenericRepo<Categoria, Integer> getRepo() {
		return repo;
	}

}
