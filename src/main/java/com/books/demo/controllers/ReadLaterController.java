package com.books.demo.controllers;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.books.demo.dao.BookRepo;
import com.books.demo.dao.ReadLaterRepo;
import com.books.demo.entities.Book;
import com.books.demo.entities.ReadLater;
import com.books.demo.service.ReadLaterService;

@Controller
public class ReadLaterController {

	@Autowired
	ReadLaterService readLaterService;

	@Autowired
	BookRepo bookRepo;

	@Autowired
	ReadLaterRepo readLaterRepo;

	@RequestMapping(value = "/saveReadLater", method = RequestMethod.GET)
	public String saveReadLater(@ModelAttribute("readLater") ReadLater readLater, Model m) {

		readLaterService.saveReadLater(readLater);

		String name = readLater.getName();
		m.addAttribute("name", name);

		String bookName = readLater.getTitle();
		m.addAttribute("bookName", bookName);

		List<Book> list = bookRepo.findAll();
		m.addAttribute("list", list);

		return "welcome";
	}

	@RequestMapping(value = "/showReadLater", method = RequestMethod.GET)
	public ModelAndView showReadLater(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("readLater") ReadLater readLater) {

		ModelAndView mav = null;

		List<ReadLater> readList = readLaterService.showReadLater(readLater.getName());

		System.out.print(readList);
		if (Objects.nonNull(readList)) {

			mav = new ModelAndView("readLater");
			List<ReadLater> list = readList;
			mav.addObject("list", list);
			mav.addObject("name", readLater.getName());

		}
		return mav;
	}

	@RequestMapping(value = "/showUserReadLater", method = RequestMethod.GET)
	public ModelAndView showUserReadLater(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("readLater") ReadLater readLater) {

		ModelAndView mav = null;

		mav = new ModelAndView("showAllUserReadLater");
		List<ReadLater> list = readLaterService.showUserReadLater();
		mav.addObject("list", list);
		mav.addObject("name", readLater.getName());

		return mav;
	}

	@RequestMapping(value = "/deleteFromReadLater", method = RequestMethod.GET)
	public ModelAndView deleteFromReadLater(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("readLater") ReadLater readLater) {

		System.out.println("calling delete method...");
		ModelAndView mav = null;
		System.out.println("readID" + readLater.getReadID());
		readLaterService.deleteFromReadLater(readLater);

		mav = new ModelAndView("readLater");
		List<ReadLater> readList = readLaterService.showReadLater(readLater.getName());
		List<ReadLater> list = readList;
		mav.addObject("list", list);
		mav.addObject("name", readLater.getName());
		mav.addObject("title", readLater.getTitle());

		return mav;
	}

}