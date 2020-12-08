package com.tiendavirtual.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendavirtual.model.Familia;
import com.tiendavirtual.repo.IFamiliaRepo;
import com.tiendavirtual.repo.IGenericRepo;
import com.tiendavirtual.service.IFamiliaService;

@Service
public class FamiliaServiceImpl extends CRUDImpl<Familia, Integer> implements IFamiliaService{

	@Autowired
	private IFamiliaRepo repo;
	
	@Transactional
	@Override
	public List<Familia> listar(Integer idCategoria) {
		return repo.listaFamiliaPorCategoria(idCategoria);
	}

	@Override
	protected IGenericRepo<Familia, Integer> getRepo() {
		return repo;
	}

}
