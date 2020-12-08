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
@Table(name="clase")
public class Clase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idClase;
	
	@Column(name="descripClase", length = 250, nullable = false)
	private String descripClase;
	
	@ManyToOne
	@JoinColumn(name="idFamilia")
	private Familia familia;
	
	@OneToMany(mappedBy = "clase")
	@JsonIgnore
	private List<Producto> listaProductoXClase;

	public Integer getIdClase() {
		return idClase;
	}

	public void setIdClase(Integer idClase) {
		this.idClase = idClase;
	}

	public String getDescripClase() {
		return descripClase;
	}

	public void setDescripClase(String descripClase) {
		this.descripClase = descripClase;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	public List<Producto> getListaProductoXClase() {
		return listaProductoXClase;
	}

	public void setListaProductoXClase(List<Producto> listaProductoXClase) {
		this.listaProductoXClase = listaProductoXClase;
	}
	
	
	
}
