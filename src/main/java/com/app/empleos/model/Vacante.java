/**
 * 
 */
package com.app.empleos.model;

import java.util.Date;

/**
 * @author victorhugo
 * @Descripcion Clase Vacante POJO
 */
public class Vacante {

	private Integer id;
	private String nombre;
	private String descripcion;
	private Date fecha;
	private Double salario;
	private Integer destacado;
	private String imagen = "noImagen.png";
	private String detalles;
	private String estatus;
	private String categoria;

	public Vacante() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	/**
	 * @return the destacado
	 */
	public Integer getDestacado() {
		return destacado;
	}

	/**
	 * @param destacado the destacado to set
	 */
	public void setDestacado(Integer destacado) {
		this.destacado = destacado;
	}

	/**
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	/**
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the detalle
	 */
	public String getDetalle() {
		return detalles;
	}

	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(String detalle) {
		this.detalles = detalle;
	}

	@Override
	public String toString() {
		return "Vacante [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha=" + fecha
				+ ", salario=" + salario + ", destacado=" + destacado + ", imagen=" + imagen + ", detalle=" + detalles
				+ ", estatus=" + estatus + ", categoria=" + categoria + "]";
	}

}
