package frgp.utn.edu.ar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import frgp.utn.edu.ar.dominio.Usuario;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String Home() {
		
		return "Home";
	}
	
	@PostMapping("/loginSuccesful")
	public String login(RedirectAttributes redirectAttributes) {
	    redirectAttributes.addAttribute("loginok", "true");
	    return "redirect:/home";
	}
	
	@GetMapping("/")
	public String InitialHome() {
		
		return "Home";
	}
	
	@GetMapping("/access-denied")
	public String AccesoDenegado() {
		
		return "AccessDenied";
	}
	
	@RequestMapping(value = {"/registro"}, method = {RequestMethod.GET, RequestMethod.POST})
	public String Registro(@ModelAttribute("usuario") Usuario usuario) {
		
		return "RegistroUsuario";
	}
}
