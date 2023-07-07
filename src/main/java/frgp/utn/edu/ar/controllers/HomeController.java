package frgp.utn.edu.ar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home.html")
	public String Home() {
		
		return "Home";
	}
	
	@GetMapping("/registro.html")
	public String Registro() {
		
		return "RegistroUsuario";
	}
}
