package frgp.utn.edu.ar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientesController {

	@GetMapping("/clientes")
	public String Clientes() {
		
		return "Clientes";
	}
}
