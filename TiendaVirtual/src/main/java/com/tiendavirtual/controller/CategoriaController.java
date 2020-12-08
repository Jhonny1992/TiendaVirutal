package com.tiendavirtual.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendavirtual.model.Categoria;
import com.tiendavirtual.service.ICategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private ICategoriaService service;
	
	@GetMapping
	public ResponseEntity<List<Categoria>>listarCategoria() throws Exception{
		List<Categoria> lista=service.listar();
		return new ResponseEntity<List<Categoria>>(lista, HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<List<Categoria>>listarCategoriaPorLinea(@PathVariable("id") Integer idLinea) throws Exception{
		List<Categoria> listacategoria = new ArrayList<>();
		listacategoria = service.listar(idLinea);
		return new ResponseEntity<List<Categoria>>(listacategoria, HttpStatus.OK);
	}
	
}
