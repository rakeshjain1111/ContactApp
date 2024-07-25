package com.rakesh.capp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
  
	@RequestMapping(value = {"/","/login"})
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/user/dashboard")
	public String userDashboard() {
		return "user_dashboard";
	}
	
	@RequestMapping(value = "/admin/dashboard")
	public String adminDashboard() {
		return "admin_dashboard";
	}
}
