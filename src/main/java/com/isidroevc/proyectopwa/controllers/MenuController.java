package com.isidroevc.proyectopwa.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
	@GetMapping(value="/")
	public String menuAdministrador() {
		return "menu";
	}
}
