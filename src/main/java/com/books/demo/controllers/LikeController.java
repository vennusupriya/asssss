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
import com.books.demo.dao.LikeBookRepo;
import com.books.demo.entities.Book;
import com.books.demo.entities.Like;
import com.books.demo.service.LikeBookService;

@Controller
public class LikeController {

	@Autowired
	LikeBookService likeBookService;

	@Autowired
	BookRepo bookRepo;

	@Autowired
	LikeBookRepo likeBookRepo;

	@RequestMapping(value = "/saveLikeBook", method = RequestMethod.GET)
	public String saveReadLater(@ModelAttribute("like") Like like, Model m) {

		likeBookService.saveLikeBook(like);

		String name = like.getName();
		m.addAttribute("name", name);

		String likeBook = like.getTitle();
		m.addAttribute("likeBook", likeBook);

		List<Book> list = bookRepo.findAll();
		m.addAttribute("list", list);

		return "welcome";
	}

	@RequestMapping(value = "/showLikeBooks", method = RequestMethod.GET)
	public ModelAndView showReadLater(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("like") Like like) {

		ModelAndView mav = null;

		List<Like> likeList = likeBookService.showLikeBooks(like.getName());

		System.out.print(likeList);
		if (Objects.nonNull(likeList)) {

			mav = new ModelAndView("like");
			List<Like> list = likeList;
			mav.addObject("list", list);
			mav.addObject("name", like.getName());

		}
		return mav;
	}

	@RequestMapping(value = "/showUserLikeBooks", method = RequestMethod.GET)
	public ModelAndView showUserLikeBooks(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("like") Like like) {

		ModelAndView mav = null;

		mav = new ModelAndView("showUserLikeBooks");
		List<Like> list = likeBookService.showUserLikeBooks();
		mav.addObject("list", list);
		mav.addObject("name", like.getName());

		return mav;
	}

	@RequestMapping(value = "/deleteFromLike", method = RequestMethod.GET)
	public ModelAndView deleteFromLike(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("like") Like like) {

		System.out.println("calling delete method...");
		ModelAndView mav = null;

		likeBookService.deleteFromLike(like);

		mav = new ModelAndView("like");
		List<Like> likeList = likeBookService.showLikeBooks(like.getName());
		List<Like> list = likeList;
		mav.addObject("list", list);
		mav.addObject("name", like.getName());
		mav.addObject("title", like.getTitle());

		return mav;
	}

}