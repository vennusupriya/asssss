package com.books.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;


import com.books.demo.entities.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {
}
