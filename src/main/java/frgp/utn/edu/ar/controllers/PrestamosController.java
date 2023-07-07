package frgp.utn.edu.ar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrestamosController {

	@GetMapping("/prestamos")
	public String Pretamos() {
		
		return "Prestamos";
	}
}
