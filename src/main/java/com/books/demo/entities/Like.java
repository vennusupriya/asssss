package com.books.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="liked_books")
public class Like {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int liked_book_id;
	private String name;
	private int book_id;
	private String title;
	private int total_pages;
	private float rating;
	private int isbn;

	public int getLiked_book_id() {
		return liked_book_id;
	}

	public void setLiked_book_id(int liked_book_id) {
		this.liked_book_id = liked_book_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

}

