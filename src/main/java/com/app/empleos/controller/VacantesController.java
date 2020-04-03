package com.app.empleos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.empleos.model.Vacante;
import com.app.empleos.service.IVacantesService;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

	@Autowired
	private IVacantesService serviceVacantes;

	@GetMapping("/delete")
	public String eliminar(@RequestParam(value = "id") int idVacante, Model model) {

		System.out.println("idVacante: " + idVacante);

		model.addAttribute("id", idVacante);

		return "mensaje";

	}

	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model model) {

		Vacante vacanteBuscada = serviceVacantes.buscarPorId(idVacante);

		System.out.println("Vacante:" + vacanteBuscada);

		System.out.println("idVacante: " + idVacante);

		model.addAttribute("vacante", serviceVacantes.buscarPorId(idVacante));
		model.addAttribute("id", idVacante);

		return "vacantes/detalle";

	}

   }
