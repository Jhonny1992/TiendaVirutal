package com.tiendavirtual.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="linea")
public class Linea {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idLinea")
	private Integer idLinea;
	
	@Column(name="descripLinea", length = 250, nullable = false)
	private String descripLinea;
	
	@OneToMany(mappedBy = "linea")
	@JsonIgnore
	private List<Categoria> listaCategoriaXLinea;

	public Integer getIdLinea() {
		return idLinea;
	}

	public void setIdLinea(Integer idLinea) {
		this.idLinea = idLinea;
	}

	public String getDescripLinea() {
		return descripLinea;
	}

	public void setDescripLinea(String descripLinea) {
		this.descripLinea = descripLinea;
	}

	public List<Categoria> getListaCategoriaXLinea() {
		return listaCategoriaXLinea;
	}

	public void setListaCategoriaXLinea(List<Categoria> listaCategoriaXLinea) {
		this.listaCategoriaXLinea = listaCategoriaXLinea;
	}

	
	

}
