package com.books.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.books.demo.entities.User;
import com.books.demo.service.UserService;

@Controller
public class RegisterController {

	@Autowired
	UserService service;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("user") User user) {
		
		service.save(user);
		
		return "login";
	}

}
