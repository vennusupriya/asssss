package com.books.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.demo.dao.BookRepo;
import com.books.demo.entities.Book;

@Service
public class BookService {
	
	@Autowired
	BookRepo bookRepo;

	public List<Book> viewBooks() {
		List<Book> books = bookRepo.findAll();
		return books;
	}

	public void addBooks(Book book) {
		bookRepo.save(book);
		
	}

	public void deleteBook(Book book) {
		
		Optional <Book> list =bookRepo.findById(book.getBook_id());
		
		if(list.isPresent()) {
			bookRepo.delete(list.get());
		}
		else {
			throw new RuntimeException("book not found");
		}
	}
	
	
}
