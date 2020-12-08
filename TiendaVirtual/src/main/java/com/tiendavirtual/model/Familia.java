package com.tiendavirtual.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="familia")
public class Familia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idFamilia")
	private Integer idFamilia;
	
	@Column(name="descripFamilia", length = 250, nullable = false)
	private String descripFamilia;
	
	@ManyToOne
	@JoinColumn(name="idCategoria")
	private Categoria categoria;
	
	@OneToMany(mappedBy ="familia")
	@JsonIgnore
	private List<Clase> listaClaseXFamilia;

	public Integer getIdFamilia() {
		return idFamilia;
	}

	public void setIdFamilia(Integer idFamilia) {
		this.idFamilia = idFamilia;
	}

	public String getDescripFamilia() {
		return descripFamilia;
	}

	public void setDescripFamilia(String descripFamilia) {
		this.descripFamilia = descripFamilia;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Clase> getListaClaseXFamilia() {
		return listaClaseXFamilia;
	}

	public void setListaClaseXFamilia(List<Clase> listaClaseXFamilia) {
		this.listaClaseXFamilia = listaClaseXFamilia;
	}
	
	
}
