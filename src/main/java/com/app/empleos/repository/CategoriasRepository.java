package com.app.empleos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.empleos.model.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {

}
