package com.app.empleos.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.empleos.model.Categoria;

@Service
public class ICategoriaServiceImpl implements ICategoriaService {

	List<Categoria> listaCategorias;

	public ICategoriaServiceImpl() {
		this.listaCategorias = getListaCategorias();
	}

	@Override
	public void guardar(Categoria categoria) {
		listaCategorias.add(categoria);
	}

	@Override
	public List<Categoria> buscarTodas() {
		return listaCategorias;
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		for (Categoria cate : listaCategorias) {
			if (cate.getId() == idCategoria) {
				return cate;
			}
		}
		return null;
	}

	private List<Categoria> getListaCategorias() {
		List<Categoria> lista = null;
		try {
			lista = new LinkedList<Categoria>();

			Categoria cate1 = new Categoria();
			cate1.setId(1);
			cate1.setNombre("Recursos Humanos");
			cate1.setDescripcion("Trabajos relacionados con el area de RH.");

			Categoria cate2 = new Categoria();
			cate2.setId(2);
			cate2.setNombre("Ventas");
			cate2.setDescripcion("Ofertas de trabajo relacionado con ventas.");

			Categoria cate3 = new Categoria();
			cate3.setId(3);
			cate3.setNombre("Arquitectura");
			cate3.setDescripcion("Diseño de planos en general y trabajos relacionados.");

			Categoria cate4 = new Categoria();
			cate4.setId(4);
			cate4.setNombre("Tecnicas");
			cate4.setDescripcion("Trabajos relacionados con trabajos tecnicos");

			Categoria cate5 = new Categoria();
			cate5.setId(5);
			cate5.setNombre("Programacion");
			cate5.setDescripcion("Trabajos en entornos de la programacion");
			
			Categoria cate6 = new Categoria();
			cate6.setId(6);
			cate6.setNombre("Educacion");
			cate6.setDescripcion("Maestros, tutores, etc");

			lista.add(cate1);
			lista.add(cate2);
			lista.add(cate3);
			lista.add(cate4);
			lista.add(cate5);
			lista.add(cate6);

		} catch (Exception e) {
			System.err.println(new Date() + "[CATEGORIAS] Error en la carga de categorias");
		}
		return lista;
	}

	@Override
	public boolean borrar(Integer idCategoria) {
		Categoria categoria = buscarPorId(idCategoria);

		if (listaCategorias.contains(categoria)) {
			listaCategorias.remove(categoria);
			return true;
		}

		return false;
	}

}
