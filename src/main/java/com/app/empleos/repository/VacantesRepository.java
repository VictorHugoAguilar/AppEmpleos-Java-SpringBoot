package com.app.empleos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.empleos.model.Vacante;

public interface VacantesRepository extends JpaRepository<Vacante, Integer> {

}
