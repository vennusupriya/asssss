package com.books.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.books.demo.service.BookService;
import com.books.demo.entities.Admin;
import com.books.demo.entities.Book;
import com.books.demo.entities.User;

@Controller
public class BookController {

	@Autowired
	BookService bookService;


	@GetMapping("/addBooks")
	public ModelAndView addBooks(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("admin") Admin admin) {
		
		ModelAndView mav = new ModelAndView("addBooks");
		mav.addObject("name", admin.getName());
		mav.addObject("book", new Book());
		
		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addBooks(@ModelAttribute("book") Book book, Model m) {

		bookService.addBooks(book);

		String name = book.getName();
		m.addAttribute("name", name);

		String bookName = book.getTitle();
		m.addAttribute("bookName", bookName);

		List<Book> list = bookService.viewBooks();
		m.addAttribute("list", list);

		return "addBooks";
	}

	@RequestMapping(value = "/deleteFromBooks", method = RequestMethod.GET)
	public ModelAndView deleteBook(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("book") Book book) {

		System.out.println("calling delete method...");
		ModelAndView mav = null;

		bookService.deleteBook(book);

		mav = new ModelAndView("adminPage");
		List<Book> list = bookService.viewBooks();
		mav.addObject("list", list);
		mav.addObject("name", book.getName());
		mav.addObject("bookName", book.getTitle());

		return mav;
	}

	@RequestMapping(value = "/adminPage", method = RequestMethod.GET)
	public ModelAndView showAdminPage(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("admin") Admin admin) {

		ModelAndView mav = null;

		mav = new ModelAndView("adminPage");
		List<Book> list = bookService.viewBooks();
		mav.addObject("list", list);
		mav.addObject("name", admin.getName());

		return mav;
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView showWelcomePage(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") User user) {

		ModelAndView mav = null;

		mav = new ModelAndView("welcome");
		List<Book> list = bookService.viewBooks();
		mav.addObject("list", list);
		mav.addObject("name", user.getName());

		return mav;
	}
}
