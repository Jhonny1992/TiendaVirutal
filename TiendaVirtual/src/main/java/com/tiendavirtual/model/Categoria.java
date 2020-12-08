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
@Table(name="categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCategoria")
	private Integer idCategoria;
	
	@Column(name="descripCategoria", length = 250, nullable = false)
	private String descripCategoria;
	
	@ManyToOne
	@JoinColumn(name="idLinea")
	private Linea linea;
	
	@OneToMany(mappedBy = "categoria")
	@JsonIgnore
	private List<Familia> listaFamiliarXCategoria;

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescripCategoria() {
		return descripCategoria;
	}

	public void setDescripCategoria(String descripCategoria) {
		this.descripCategoria = descripCategoria;
	}

	public Linea getLinea() {
		return linea;
	}

	public void setLinea(Linea linea) {
		this.linea = linea;
	}

	public List<Familia> getListaFamiliarXCategoria() {
		return listaFamiliarXCategoria;
	}

	public void setListaFamiliarXCategoria(List<Familia> listaFamiliarXCategoria) {
		this.listaFamiliarXCategoria = listaFamiliarXCategoria;
	}
	
	
	
}
