package com.rakesh.capp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rakesh.capp.command.LoginCommand;
import com.rakesh.capp.command.UserCommand;
import com.rakesh.capp.domain.User;
import com.rakesh.capp.exception.UserBlockedException;
import com.rakesh.capp.services.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"/","/index"})
	public String index(Model m) {
		m.addAttribute("command",new LoginCommand());
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handelLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session) {
			try {
				User loggedUser=userService.login(cmd.getLoginName(), cmd.getPassword());
				System.out.println(loggedUser);
				if(loggedUser==null) {
					m.addAttribute("err","Login Failed! Enter valid credentials");
					return "index";
				}else {
					if(loggedUser.getRole().equals(UserService.ROLE_ADMIN)) {
						addUserInSession(loggedUser, session);
						return "redirect:admin/dashboard";
					}else if(loggedUser.getRole().equals(UserService.ROLE_USER)) {
						addUserInSession(loggedUser, session);
						return "redirect:user/dashboard";
					}else {
						m.addAttribute("err","Invalid User");
						return "index";
					}
					
				}
				
			} catch (UserBlockedException e) {
				m.addAttribute("err",e.getMessage());
				return "index";
			}
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index?act=lo";
	}
	
	@RequestMapping(value = "/regi_form")
	public String registrationForm( Model m) {
		UserCommand cmd = new UserCommand();
		m.addAttribute("command" ,cmd);
		return "user_register";
	}
	
	@RequestMapping(value = "/register")
	public String UserRegistration(@ModelAttribute("command") UserCommand cmd, Model m) {
		try {
			User u= cmd.getUser();
			u.setRole(userService.ROLE_USER);
			u.setLoginStatus(userService.LOGIN_STATUS_ACTIVE);
			userService.register(u);
			return "redirect:index?act=reg";
		} catch (DuplicateKeyException e) {
			e.printStackTrace();
			m.addAttribute("err","UserName already exists...Choose another");
			return "user_register";
		}

	}
	
	@RequestMapping(value = "/user/dashboard")
	public String userDashboard() {
		return "user_dashboard";
	}
	
	@RequestMapping(value = "/admin/dashboard")
	public String adminDashboard() {
		return "admin_dashboard";
	}
	
	private void addUserInSession(User u, HttpSession session) 
	{
		session.setAttribute("user", u);
		session.setAttribute("userId", u.getUserId());
		session.setAttribute("role", u.getRole());
	}
}
