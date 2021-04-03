package mx.com.eb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;
import mx.com.eb.dao.IPersonaDao;

@Controller
@Slf4j
public class ControllerInicio{

	@Autowired // se llama la interfaz dao para injectar los metodos
	private IPersonaDao IPersonaDao;
	
	@GetMapping("/")
	public String inicio(Model model) {
		var personas = IPersonaDao.findAll();
		log.info("ejecutando el controlador Spring MVC");
		model.addAttribute("personas",personas);
		return "index";
	}
	
}
