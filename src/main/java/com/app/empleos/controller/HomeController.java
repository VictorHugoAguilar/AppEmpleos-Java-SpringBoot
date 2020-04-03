package com.app.empleos.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.empleos.model.Vacante;
import com.app.empleos.service.IVacantesService;

@Controller
public class HomeController {
	
	@Autowired
	private IVacantesService serviceVacantes;

	@GetMapping("/tablas")
	public String mostrarTabla(Model model) {

		model.addAttribute("vacantes", serviceVacantes.buscarTodas() );

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


}
