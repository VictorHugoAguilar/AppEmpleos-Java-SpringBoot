package com.app.empleos.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.empleos.model.Vacante;

@Controller
public class HomeController {

	@GetMapping("/tablas")
	public String mostrarTabla(Model model) {

		model.addAttribute("vacantes", getVacantes());

		return "tablas";
	}

	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {

		Vacante vacante = new Vacante();
		vacante.setId((int) new Date().getTime());
		vacante.setNombre("Programador Web");
		vacante.setDescripcion("Programador Web para app de banco");
		vacante.setFecha(new Date());
		vacante.setSalario(980.0);

		model.addAttribute("vacante", vacante);

		return "detalle";

	}

	@GetMapping("/")
	public String mostrarHome(Model model) {

		model.addAttribute("mensaje", "Hola desde el controller");
		model.addAttribute("fecha", new Date());

		return "home";

	}

	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> ofertas = new LinkedList<String>();

		ofertas.add("Ingeniero de Sistemas");
		ofertas.add("Auxiliar de contabilidad");
		ofertas.add("Vendedor");
		ofertas.add("Arquitecto");

		model.addAttribute("empleos", ofertas);

		return "listado";

	}

	private List<Vacante> getVacantes() {
		List<Vacante> listaVacantes = new LinkedList<Vacante>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		try {

			// Creamos trabajo 1
			Vacante vacante = new Vacante();
			vacante.setId((int) (new Date().getTime() * Math.random()));
			vacante.setNombre("Programador Web");
			vacante.setDescripcion("Programador Web para app de banco");
			vacante.setFecha(sdf.parse("01-04-2020"));
			vacante.setSalario(680.0);
			vacante.setDestacado(1);
			vacante.setImagen("logo1.jpg");

			// Creamos trabajo 1
			Vacante vacante1 = new Vacante();
			vacante1.setId((int) (new Date().getTime() * Math.random()));
			vacante1.setNombre("Programador App");
			vacante1.setDescripcion("Programador App para app de banco");
			vacante1.setFecha(sdf.parse("01-04-2020"));
			vacante1.setSalario(480.0);
			vacante1.setDestacado(0);
			vacante1.setImagen("logo2.png");

			// Creamos trabajo 1
			Vacante vacante2 = new Vacante();
			vacante2.setId((int) (new Date().getTime() * Math.random()));
			vacante2.setNombre("Fisico");
			vacante2.setDescripcion("Fisico para instituto de ciencia");
			vacante2.setFecha(sdf.parse("01-04-2020"));
			vacante2.setSalario(980.0);
			vacante2.setDestacado(0);
			vacante2.setImagen("logo3.png");

			// Creamos trabajo 1
			Vacante vacante3 = new Vacante();
			vacante3.setId((int) (new Date().getTime() * Math.random()));
			vacante3.setNombre("Medico");
			vacante3.setDescripcion("Medico para residencia de ancianos");
			vacante3.setFecha(sdf.parse("02-04-2020"));
			vacante3.setSalario(1280.0);
			vacante3.setDestacado(1);
			vacante3.setImagen("logo4.jpg");

			// Creamos trabajo 1
			Vacante vacante4 = new Vacante();
			vacante4.setId((int) (new Date().getTime() * Math.random()));
			vacante4.setNombre("Enfermero");
			vacante4.setDescripcion("Enfermero para guardia en clininca");
			vacante4.setFecha(sdf.parse("02-04-2020"));
			vacante4.setSalario(1980.0);
			vacante4.setDestacado(1);
			vacante4.setImagen("logo5.jpg");

			listaVacantes.add(vacante4);
			listaVacantes.add(vacante1);
			listaVacantes.add(vacante2);
			listaVacantes.add(vacante3);
			listaVacantes.add(vacante);

		} catch (Exception e) {
			System.err.println("Fallo en alguna insercion de vacantes");
		}

		return listaVacantes;
	}

}
