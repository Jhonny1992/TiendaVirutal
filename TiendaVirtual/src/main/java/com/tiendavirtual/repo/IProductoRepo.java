package com.tiendavirtual.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tiendavirtual.model.Producto;

public interface IProductoRepo extends IGenericRepo<Producto, Integer> {
	//por la interfaz JPAREPOSITORY TENGO EL CRUD sin hacerlo.
	@Query("FROM Producto p  Where p.clase.idClase = :idClase")
	List<Producto> listaProductoPorClase (@Param("idClase") Integer idClase);
	
	@Query(value="call GETPRODUCTOSLCFC", nativeQuery = true)
	List<Object[]> listarProductosLCFC();
	
}
