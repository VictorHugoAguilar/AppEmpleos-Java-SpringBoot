package com.app.empleos.controller;

import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.empleos.model.Categoria;
import com.app.empleos.service.ICategoriaService;

@Controller
@RequestMapping(value = "/categorias")
public class CategoriaController {

	@Autowired
	private ICategoriaService serviceCategoria;

	// GetMapping("/index")
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String mostrarIndex(Model model) {

		model.addAttribute("categorias", serviceCategoria.buscarTodas());

		return "categorias/listCategorias";
	}

	// @GetMapping("/create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String crear() {
		return "categorias/formCategoria";

	}

	// PostMapping("/save")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String guardar(Categoria categoria, BindingResult result, RedirectAttributes attributes) {

		// Comprobamos si hay errores en el data-binding
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}

			return "categorias/formCategoria";
		}

		System.out.println(new Time() + "[CATEGORIA] ...Guardar " + categoria);

		categoria.setId(serviceCategoria.buscarTodas().size() + 1);
		serviceCategoria.guardar(categoria);

		attributes.addFlashAttribute("msg", "Registro Guardado");

		return "redirect:/categorias/index";
	}

	@GetMapping("/delete")
	public String detele(@RequestParam(value = "idCategoria") int idCategoria, RedirectAttributes attributes) {

		System.out.println(new Time() + "[CATEGORIA] ...Borrando id " + idCategoria);

		boolean borrado = serviceCategoria.borrar(idCategoria);

		if (borrado) {
			attributes.addFlashAttribute("msg", "Registro Borrado");
		}

		return "redirect:/categorias/index";

	}

}
