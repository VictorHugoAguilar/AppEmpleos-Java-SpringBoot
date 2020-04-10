package com.app.empleos.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.app.empleos.model.Vacante;
import com.app.empleos.repository.VacantesRepository;
import com.app.empleos.service.IVacantesService;

@Service
@Primary
public class VacantesServiceJpa implements IVacantesService {

	@Autowired
	private VacantesRepository vacantesRepo;

	@Override
	public List<Vacante> buscarTodas() {

		return vacantesRepo.findAll();

	}

	@Override
	public Vacante buscarPorId(Integer id) {

		Optional<Vacante> vacanteEncontrada = vacantesRepo.findById(id);

		if (vacanteEncontrada.isPresent()) {

			return vacanteEncontrada.get();

		}

		return null;
	}

	@Override
	public void guardar(Vacante vacante) {

		vacantesRepo.save(vacante);

	}

	@Override
	public boolean borrar(Integer id) {

		Optional<Vacante> vacanteEncontrada = vacantesRepo.findById(id);

		if (vacanteEncontrada.isPresent()) {

			vacantesRepo.delete(vacanteEncontrada.get());

			return true;

		}

		return false;
	}

	@Override
	public List<Vacante> buscarDestacadas() {
		return vacantesRepo.findByEstatusAndDestacadoOrderByFechaDesc("Aprobada",  1);
	}

}
