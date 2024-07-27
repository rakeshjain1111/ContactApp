package com.rakesh.capp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rakesh.capp.domain.Contact;
import com.rakesh.capp.services.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;
		
	@RequestMapping(value="/user/contactform")
	public String contactForm(Model m) {
		m.addAttribute("command", new Contact());
		return "contact_form";
	}
	
	@RequestMapping(value="/user/saveContact")
	public String saveContact(@ModelAttribute("command") Contact c, Model m, HttpSession session) {
		try {
			Integer userId=(Integer) session.getAttribute("userId");
			c.setUserId(userId);
			contactService.save(c);
			m.addAttribute("command", new Contact());
			return "redirect:clist?act=sv";
		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("err", "Failed to save contact");
			return "contact_form";
		}
	}
	
	@RequestMapping(value="/user/clist")
	public String contactList(Model m) {
		return "clist"; //TODO
	}
}
