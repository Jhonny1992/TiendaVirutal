package com.tiendavirtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendavirtual.exception.ModeloNotFoundException;
import com.tiendavirtual.model.Cliente;
import com.tiendavirtual.model.Producto;
import com.tiendavirtual.service.IClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private IClienteService service;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listar() throws Exception{
		List<Cliente> lista=service.listar();
		return new ResponseEntity<List<Cliente>>(lista, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Cliente>listarPorId(@PathVariable("id") Integer id) throws Exception{
		Cliente obj=service.listarPorId(id);
		
		if(obj ==null) {
			
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		
		return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
	}
}
