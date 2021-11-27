package com.books.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.books.demo.entities.Admin;
import com.books.demo.service.AdminService;

@Controller
public class AdminRegisterController {

	@Autowired
	AdminService service;

	@GetMapping("/adminRegister")
	public ModelAndView adminRegister() {
		ModelAndView mav = new ModelAndView("adminRegister");
		mav.addObject("admin", new Admin());
		return mav;
	}

	@RequestMapping(value = "/adminRegister", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("admin") Admin admin) {
		ModelAndView mav = null;
		String systemCode = "123456";
		if (systemCode.equals(admin.getSystemCode())) {
			service.save(admin);
			mav = new ModelAndView("adminLogin");
			mav.addObject("message", "Admin Is Register Successfully...");
		} else {
			mav = new ModelAndView("adminLogin");
			mav.addObject("message", "System Code is Wrong!!!");
		}
		return mav;
	}

}
