package com.books.demo.controllers;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.books.demo.dao.BookRepo;
import com.books.demo.entities.Admin;
import com.books.demo.entities.Book;
import com.books.demo.entities.User;
import com.books.demo.service.AdminService;
import com.books.demo.service.UserService;

@Controller
public class AdminLoginController {
	@Autowired
	private AdminService adminService;

	@Autowired
	BookRepo bookRepo;

	@Autowired
	private UserService userService;

	@GetMapping("/adminLogin")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("adminLogin");
		mav.addObject("admin", new Admin());
		return mav;
	}

	@PostMapping("/adminLogin")
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("admin") Admin admin) {

		ModelAndView mav = null;

		Admin oauthUser = adminService.adminLogin(admin.getName(), admin.getPassword());

		System.out.print(oauthUser);
		if (Objects.nonNull(oauthUser)) {

			mav = new ModelAndView("adminPage");
			List<Book> list = bookRepo.findAll();
			mav.addObject("list", list);
			mav.addObject("name", admin.getName());

		} else {

			mav = new ModelAndView("adminLogin");
			mav.addObject("message", "Username or Password is wrong!!");

		}
		return mav;
	}

	@RequestMapping(value = "/showUsers", method = RequestMethod.GET)
	public ModelAndView showUsers(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("admin") Admin admin) {

		ModelAndView mav = null;

		mav = new ModelAndView("showUsers");
		List<User> list = userService.showUser();
		mav.addObject("list", list);
		mav.addObject("name", admin.getName());

		return mav;
	}

	}
