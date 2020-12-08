package com.tiendavirtual.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendavirtual.model.Cliente;
import com.tiendavirtual.repo.IClienteRepo;
import com.tiendavirtual.repo.IGenericRepo;
import com.tiendavirtual.service.IClienteService;

@Service
public class ClienteServiceImpl extends CRUDImpl<Cliente, Integer> implements IClienteService{

	@Autowired
	private IClienteRepo repo;
	
	@Override
	protected IGenericRepo<Cliente, Integer> getRepo() {
		return repo;
	}
}
