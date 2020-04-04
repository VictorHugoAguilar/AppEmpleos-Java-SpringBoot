package com.app.empleos.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.empleos.model.Vacante;
import com.app.empleos.service.IVacantesService;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

	@Autowired
	private IVacantesService serviceVacantes;

	@GetMapping("/index")
	public String verVacantes(Model model) {

		List<Vacante> vacantes = serviceVacantes.buscarTodas();
		
		model.addAttribute("vacantes", vacantes);

		return "vacantes/listVacantes";
	}

	@GetMapping("/create")
	public String crear() {

		System.out.println("crear vacantes");

		return "vacantes/formVacante";
	}

	@PostMapping("/save")
	public String guardar(Vacante vacante, BindingResult result) {

		/**
		 * Comprobamos si hay errores en el data-binding
		 */
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}

			return "vacantes/formVacante";
		}

		System.err.println(new Date() + "[GUARDANDO...]");

		System.err.println(vacante);

		serviceVacantes.guardar(vacante);

		return "vacantes/listVacantes";
	}

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

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
