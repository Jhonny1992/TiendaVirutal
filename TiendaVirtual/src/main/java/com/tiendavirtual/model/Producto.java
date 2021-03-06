package com.tiendavirtual.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idProducto")
	private Integer idProducto;
	
	@Column(name="codigoProducto", length=20,nullable = false)
	private String codigoProducto;
	
	@Column(name="nombreProducto", length=20,nullable = false)
	private String nombreProducto;
	
	@Column(name="descripcionProducto", length=150,nullable = false)
	private String descripcionProducto;
	
	@Column(name="fotoProducto", length=10,nullable = true)
	@JsonIgnore
	private byte[] fotoProducto;
	
	@Column(name="precioProducto", length=10,nullable = false)
	private Double precioProducto;
	
	@ManyToOne
	@JoinColumn(name="idClase")
	private Clase clase;

	
	
	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public byte[] getFotoProducto() {
		return fotoProducto;
	}

	public void setFotoProducto(byte[] fotoProducto) {
		this.fotoProducto = fotoProducto;
	}

	public Double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(Double precioProducto) {
		this.precioProducto = precioProducto;
	}
	
	
	
	

}
