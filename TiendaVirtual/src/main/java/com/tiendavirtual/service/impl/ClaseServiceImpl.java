package com.tiendavirtual.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendavirtual.model.Clase;
import com.tiendavirtual.repo.IClaseRepo;
import com.tiendavirtual.repo.IGenericRepo;
import com.tiendavirtual.service.IClaseService;

@Service
public class ClaseServiceImpl extends CRUDImpl<Clase, Integer> implements IClaseService{

	@Autowired
	private IClaseRepo repo;
	
	@Transactional
	@Override
	public List<Clase> listar(Integer idFamilia) {
		return repo.listaClasePorFamilia(idFamilia);
	}

	@Override
	protected IGenericRepo<Clase, Integer> getRepo() {
		return repo;
	}
	

}
