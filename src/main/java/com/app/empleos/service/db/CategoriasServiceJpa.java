package com.app.empleos.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.empleos.model.Categoria;
import com.app.empleos.repository.CategoriasRepository;
import com.app.empleos.service.ICategoriaService;

@Service
public class CategoriasServiceJpa implements ICategoriaService {

	@Autowired
	private CategoriasRepository categoriasRepo;

	@Override
	public void guardar(Categoria categoria) {

		categoriasRepo.save(categoria);
	}

	@Override
	public List<Categoria> buscarTodas() {

		return categoriasRepo.findAll();

	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {

		Optional<Categoria> categoriaBuscada = categoriasRepo.findById(idCategoria);

		if (categoriaBuscada.isPresent()) {
			return categoriaBuscada.get();
		}

		return null;
	}

	@Override
	public boolean borrar(Integer idCategoria) {

		Optional<Categoria> categoriaBuscada = categoriasRepo.findById(idCategoria);

		if (!categoriaBuscada.isPresent()) {
			return false;
		}

		categoriasRepo.delete(categoriaBuscada.get());

		return true;
	}

}
