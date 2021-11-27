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
import org.springframework.web.servlet.ModelAndView;

import com.books.demo.dao.BookRepo;
import com.books.demo.entities.Book;
import com.books.demo.entities.User;
import com.books.demo.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	@Autowired
	BookRepo bookRepo;

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new User());
		return mav;
	}

	@PostMapping("/login")
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") User user) {

		ModelAndView mav = null;

		User oauthUser = userService.login(user.getName(), user.getPassword());

		System.out.print(oauthUser);
		if (Objects.nonNull(oauthUser)) {

			mav = new ModelAndView("welcome");
			List<Book> list = bookRepo.findAll();
			mav.addObject("list", list);
			mav.addObject("name", user.getName());
			mav.addObject("id", user.getId());

		} else {

			mav = new ModelAndView("login");
			mav.addObject("message", "Username or Password is wrong!!");

		}
		return mav;
	}

}
