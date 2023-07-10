package frgp.utn.edu.ar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PrestamosController {

	@RequestMapping(value = {"/prestamos"}, method = {RequestMethod.GET, RequestMethod.POST})
	public String Pretamos() {
		
		return "Prestamos";
	}
}
