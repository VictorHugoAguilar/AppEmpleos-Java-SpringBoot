package com.app.empleos.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.empleos.model.Vacante;
import com.app.empleos.service.ICategoriaService;
import com.app.empleos.service.IVacantesService;
import com.app.empleos.util.Utileria;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

	@Value("${empleosapp.ruta.imagenes}")
	private String ruta;
	
	@Autowired
	private IVacantesService serviceVacantes;
	@Autowired
	private ICategoriaService serviceCategorias;

	@GetMapping("/index")
	public String verVacantes(Model model) {

		List<Vacante> vacantes = serviceVacantes.buscarTodas();

		model.addAttribute("vacantes", vacantes);

		return "vacantes/listVacantes";
	}

	@GetMapping("/create")
	public String crear(Vacante vacante, Model model) {

		System.out.println(new Time() + "[VACANTES] ...Creando nueva vacante");

		model.addAttribute("categorias", serviceCategorias.buscarTodas());

		return "vacantes/formVacante";
	}

	@PostMapping("/save")
	public String guardar(Vacante vacante, BindingResult result, RedirectAttributes attributes,
			@RequestParam("archivoImagen") MultipartFile multiPart) {

		/**
		 * Comprobamos si hay errores en el data-binding
		 */
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}

			return "vacantes/formVacante";
		}

		if (!multiPart.isEmpty()) {

			// String ruta = "/Users/victorhugo/workspaceEclipse/empleos/img-vacantes/";
			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if (nombreImagen != null) { // La imagen si se subio
				// Procesamos la variable nombreImagen
				vacante.setImagen(nombreImagen);
			}
		}

		System.err.println(new Date() + "[GUARDANDO...]");
		System.err.println(vacante);

		serviceVacantes.guardar(vacante);

		attributes.addFlashAttribute("msg", "Registro Guardado");

		return "redirect:/vacantes/index";
	}

	@GetMapping("/delete")
	public String eliminar(@RequestParam(value = "idVacante") int idVacante, RedirectAttributes attributes) {
		System.out.println(new Time() + "[VACANTE] ...Borrando id " + idVacante);
		boolean borrado = serviceVacantes.borrar(idVacante);

		if (borrado) {
			attributes.addFlashAttribute("msg", "Registro Borrado");
		}

		return "redirect:/vacantes/index";
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
