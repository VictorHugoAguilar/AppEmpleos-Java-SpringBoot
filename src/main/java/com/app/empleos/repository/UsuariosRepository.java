package com.app.empleos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.empleos.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}
