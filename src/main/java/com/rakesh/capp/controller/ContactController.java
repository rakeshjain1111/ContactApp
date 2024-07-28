package com.rakesh.capp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String SaveOrUpdateContact(@ModelAttribute("command") Contact c, Model m, HttpSession session) {
		Integer contactId=(Integer) session.getAttribute("aContactId");
		if(contactId==null) {
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
		}else {
			try {
				c.setContactId(contactId);
				contactService.update(c);
				return "redirect:clist?act=up";
			} catch (Exception e) {
				e.printStackTrace();
				m.addAttribute("err", "Failed to update contact");
				return "contact_form";
			}
		}
		
	
	}
	
	@RequestMapping(value="/user/clist")
	public String contactList(Model m ,HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		m.addAttribute("clist",contactService.findUserContact(userId));
		return "clist"; 
	}
	
	@RequestMapping(value="/user/contact_search")
	public String contactSearch(Model m ,HttpSession session, @RequestParam("freetext") String freetext) {
		Integer userId = (Integer) session.getAttribute("userId");
		m.addAttribute("clist",contactService.findUserContact(userId,freetext));
		return "clist"; 
	}
	
	@RequestMapping(value="/user/deleteContact")
	public String deleteContact(@RequestParam("cid") Integer contactId ) {
		contactService.delete(contactId);
		return "redirect:clist?act=del";
	}
	
	@RequestMapping(value="/user/bulk_cdelete")
	public String deleteBulkContact(@RequestParam("cid") Integer[] contactIds ) {
		contactService.delete(contactIds);
		return "redirect:clist?act=del";
	}
	
	
	@RequestMapping(value="/user/editContact")
	public String editContact(@RequestParam("cid") Integer contactId, HttpSession session, Model m ) {
		session.setAttribute("aContactId", contactId);
		Contact contact =contactService.findById(contactId);
		m.addAttribute("command",contact);
		return "contact_form";
	}
}
