package com.tiendavirtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendavirtual.model.Categoria;
import com.tiendavirtual.model.Linea;
import com.tiendavirtual.service.ICategoriaService;
import com.tiendavirtual.service.ILineaService;

@RestController
@RequestMapping("/lineas")
public class LineaController {
	
	@Autowired
	private ILineaService service;
	
	@GetMapping
	public ResponseEntity<List<Linea>>listarLinea() throws Exception{
		List<Linea> lista=service.listar();
		return new ResponseEntity<List<Linea>>(lista, HttpStatus.OK);
	}
	

}
