package com.tiendavirtual.controller;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tiendavirtual.exception.ModeloNotFoundException;
import com.tiendavirtual.model.Categoria;
import com.tiendavirtual.model.Clase;
import com.tiendavirtual.model.Familia;
import com.tiendavirtual.model.Linea;
import com.tiendavirtual.model.Producto;
import com.tiendavirtual.service.ICategoriaService;
import com.tiendavirtual.service.IClaseService;
import com.tiendavirtual.service.IFamiliaService;
import com.tiendavirtual.service.ILineaService;
import com.tiendavirtual.service.IProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private IProductoService service;
	@Autowired
	private ILineaService lineaservice;
	@Autowired
	private ICategoriaService categoriaservice;
	@Autowired
	private IFamiliaService familiaservice;
	@Autowired
	private IClaseService claseservice;
	
	@GetMapping
	public ResponseEntity<List<Producto>> listar() throws Exception{
		List<Producto> lista=service.listar();
		return new ResponseEntity<List<Producto>>(lista, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody Producto producto) throws Exception{
		Producto obj =service.registrar(producto);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdProducto()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Producto> modificar(@Valid @RequestBody Producto producto) throws Exception{
		Producto obj = service.modificar(producto);
		return new ResponseEntity<Producto>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id)throws Exception{
		Producto obj = service.listarPorId(id);
		if(obj ==null) {	
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Producto>listarPorId(@PathVariable("id") Integer id) throws Exception{
		Producto obj=service.listarPorId(id);
		
		if(obj ==null) {	
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		return new ResponseEntity<Producto>(obj, HttpStatus.OK);
	}
	
	
	@GetMapping("/productos")
	public ResponseEntity<List<Producto>> listarLCFC() throws Exception{
		List<Producto> lista=service.listaProductoLCFC();
		return new ResponseEntity<List<Producto>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/foto")
	public ResponseEntity<byte[]> verFoto(@RequestParam("codigo") int id)throws Exception {
		Producto bean=service.listarPorId(id);
		byte[] image=bean.getFotoProducto();
		return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(image);
	}
	
	@GetMapping("/linea")
	public ResponseEntity<List<Linea>>listarLinea() throws Exception{
		List<Linea> lista=lineaservice.listar();
		return new ResponseEntity<List<Linea>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/categoria")
	public ResponseEntity<List<Categoria>>listarCategoria() throws Exception{
		List<Categoria> lista=categoriaservice.listar();
		return new ResponseEntity<List<Categoria>>(lista, HttpStatus.OK);
	}
	
	@GetMapping(value="/listcategoria/{id}")
	public ResponseEntity<List<Categoria>>listarCategoriaPorLinea(@PathVariable("id") Integer idLinea) throws Exception{
		List<Categoria> listacategoria = new ArrayList<>();
		listacategoria = categoriaservice.listar(idLinea);
		return new ResponseEntity<List<Categoria>>(listacategoria, HttpStatus.OK);
	}
	
	@GetMapping("/listfamilia/{id}")
	public ResponseEntity<List<Familia>>listarFamiliaPorCategoria(@PathVariable("id") Integer idCategoria) throws Exception{
		List<Familia> listafamilia = new ArrayList<>();
		listafamilia = familiaservice.listar(idCategoria);
		return new ResponseEntity<List<Familia>>(listafamilia, HttpStatus.OK);
	}
	
	@GetMapping("/listclase/{id}")
	public ResponseEntity<List<Clase>>listarClasePorFamilia(@PathVariable("id") Integer idFamilia) throws Exception{
		List<Clase> listaclase = new ArrayList<>();
		listaclase = claseservice.listar(idFamilia);
		return new ResponseEntity<List<Clase>>(listaclase, HttpStatus.OK);
	}
	
	
	
}
