package com.tiendavirtual.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendavirtual.model.Linea;
import com.tiendavirtual.repo.IGenericRepo;
import com.tiendavirtual.repo.ILineaRepo;
import com.tiendavirtual.service.ILineaService;
@Service
public class LineaServiceImpl extends CRUDImpl<Linea, Integer> implements ILineaService{

	@Autowired
	private ILineaRepo repo;
	
	@Transactional
	@Override
	protected IGenericRepo<Linea, Integer> getRepo() {
		return repo;
	}

}