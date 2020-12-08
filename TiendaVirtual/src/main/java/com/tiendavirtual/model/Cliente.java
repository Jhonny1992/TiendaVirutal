package com.tiendavirtual.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="cliente")
public class Cliente {	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idCliente")
	private Integer idCliente;
	
	@Column(name="codigoCliente", length=5, nullable=false)
	private String codigoCliente;
	
	@Column(name="usuarioCliente",length=50, nullable=false)
	private String usuarioCliente;
	
	@Column(name="contraseñaCliente",length=50, nullable=false)
	private String contraseñaCliente;
	
	@Column(name="nombresCliente", length= 250, nullable=false)
	private String nombresCliente;
	
	@Column(name="paternoCliente",length=100, nullable=false)
	private String paternoCliente;
	
	@Column(name="maternoCliente",length=100, nullable=false)
	private String maternoCliente;
	
	@Column(name="fechaNacCliente", nullable=false)
	private LocalDateTime fechaNacCliente;
	
	@Column(name="direccionCliente",length=350, nullable=false)
	private String direccionCliente;

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getUsuarioCliente() {
		return usuarioCliente;
	}

	public void setUsuarioCliente(String usuarioCliente) {
		this.usuarioCliente = usuarioCliente;
	}

	public String getContraseñaCliente() {
		return contraseñaCliente;
	}

	public void setContraseñaCliente(String contraseñaCliente) {
		this.contraseñaCliente = contraseñaCliente;
	}

	public String getNombresCliente() {
		return nombresCliente;
	}

	public void setNombresCliente(String nombresCliente) {
		this.nombresCliente = nombresCliente;
	}

	public String getPaternoCliente() {
		return paternoCliente;
	}

	public void setPaternoCliente(String paternoCliente) {
		this.paternoCliente = paternoCliente;
	}

	public String getMaternoCliente() {
		return maternoCliente;
	}

	public void setMaternoCliente(String maternoCliente) {
		this.maternoCliente = maternoCliente;
	}

	public LocalDateTime getFechaNacCliente() {
		return fechaNacCliente;
	}

	public void setFechaNacCliente(LocalDateTime fechaNacCliente) {
		this.fechaNacCliente = fechaNacCliente;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}
	
	
	
	

}
