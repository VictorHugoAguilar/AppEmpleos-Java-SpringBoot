package com.app.empleos.service;

import java.util.List;

import com.app.empleos.model.Categoria;

public interface ICategoriaService {

	void guardar(Categoria categoria);

	List<Categoria> buscarTodas();

	Categoria buscarPorId(Integer idCategoria);

	boolean borrar(Integer idCategoria);

}
