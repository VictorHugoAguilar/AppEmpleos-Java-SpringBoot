package com.app.empleos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Perfiles")
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="perfil")
	private String perfil;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the perfil
	 */
	public String getPerfil() {
		return perfil;
	}

	/**
	 * @param perfil the perfil to set
	 */
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "Perfil [id=" + id + ", perfil=" + perfil + "]";
	}
	
	
	
	
}
