package mx.com.eb.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import mx.com.eb.domain.Persona;
import mx.com.eb.service.PersonaService;

@Controller
@Slf4j
public class ControllerInicio{

	@Autowired // se llama la interfaz dao para injectar los metodos
	private PersonaService personaService;
	
	@GetMapping("/")
	public String inicio(Model model) {
		var personas = personaService.listaPersona();
		log.info("ejecutando el controlador Spring MVC");
		model.addAttribute("personas",personas);
		return "index";
	}
	
	@GetMapping("/agregar")
	public String agregar(Persona persona) {
		return "modificar";
	}
	
	@PostMapping("/guarda")
	public String guardar(@Valid Persona persona, Errors errors) {
		if(errors.hasErrors()) {
			return "modificar";
		}
		personaService.guardar(persona);
		return "redirect:/";
	}
	
	@GetMapping("/editar/{idPersona}")
	public String editar(Persona persona, Model model) {
		persona = personaService.encontrarPersona(persona);
		model.addAttribute("persona", persona);
		return "modificar";
	}
	
	@GetMapping("/eliminar")
	public String eliminar(Persona persona) {
		
		personaService.eliminar(persona);
		
		return "redirect:/";
	}
}
