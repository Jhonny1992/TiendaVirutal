package com.tiendavirtual.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tiendavirtual.model.Clase;

public interface IClaseRepo extends IGenericRepo<Clase, Integer> {
	
	@Query("FROM Clase c where c.familia.idFamilia= :idFamilia")
	List<Clase> listaClasePorFamilia(@Param("idFamilia") Integer idFamilia);

}
