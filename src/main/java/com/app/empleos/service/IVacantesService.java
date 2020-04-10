package com.app.empleos.service;

import java.util.List;

import com.app.empleos.model.Vacante;

public interface IVacantesService {

	List<Vacante> buscarTodas();

	Vacante buscarPorId(Integer id);

	void guardar(Vacante vacante);
	
	boolean borrar(Integer id);
	
	List<Vacante> buscarDestacadas();

}
