package mx.com.eb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;
import mx.com.eb.domain.Persona;

@Controller
@Slf4j
public class ControllerInicio {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ControllerInicio.class);
	
	@Value("${index.saludos}")
	private String mensaje;
	@GetMapping("/")
	public String inicio(Model model) {
		var mensaje = this.mensaje;
		var persona = new Persona();
		
		log.info("ejecutando el controlador Spring MVC");
		model.addAttribute("mensaje",mensaje);
		return "index";
	}
	
}
