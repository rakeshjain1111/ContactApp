package com.rakesh.capp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	@RequestMapping(value = {"/","/home"})
	public String homepage() {
		return "index";
	}
}
