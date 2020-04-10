package com.app.empleos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.empleos.model.Vacante;

public interface VacantesRepository extends JpaRepository<Vacante, Integer> {

	List<Vacante> findByEstatusAndDestacadoOrderByFechaDesc(String estatus, int destacado);
	
}
