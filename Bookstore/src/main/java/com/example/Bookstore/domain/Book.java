package com.example.Bookstore.domain;

public class Book {
	
	
	public String title;	
	public String author;	
	public int year;	
	public String isbn;
	public double price;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title= title;	
	}

	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author= author;	
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year= year;	
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn= isbn;	
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price= price;	
	}
}
