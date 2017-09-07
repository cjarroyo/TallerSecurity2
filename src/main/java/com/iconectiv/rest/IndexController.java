package com.iconectiv.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping(value={"/", "/login"})
	public String login(){
		return "login";
	}

	@RequestMapping(value="/registration")
	public String getRegistrationPage() {
		return "registration";
	}
	
	@RequestMapping(value="/consultaprevia")
	public String getConsultaPreviaPage() {
		return "consultaprevia";
	}
	
}


