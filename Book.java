package com.graded.assignment;


public class Book { 
	
	  int bookId;
	  String name;
	  int price;
	  String genre;
	  int noOfCopiesSold;
	  String status;

	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return name;
	}
	public void setBookName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getNoOfCopiesSold() {
		return noOfCopiesSold;
	}
	public void setNoOfCopiesSold(int noOfCopiesSold) {
		this.noOfCopiesSold = noOfCopiesSold;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status.toUpperCase();
	}
}
	  
	 
	 