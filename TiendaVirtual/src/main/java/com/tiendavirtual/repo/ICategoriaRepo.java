package com.tiendavirtual.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tiendavirtual.model.Categoria;

public interface ICategoriaRepo extends IGenericRepo<Categoria, Integer>{
	
	@Query(value="call SPGETCATEGORIAXLINEA(:idLinea)", nativeQuery = true)
	List<Categoria> listaCategoriaPorLinea(@Param("idLinea") Integer idLinea);

}
