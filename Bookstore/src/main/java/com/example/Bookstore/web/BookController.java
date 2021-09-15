package com.example.Bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Bookstore.domain.Book;

	

@Controller
public class BookController {
	
	private List<Book> books = new ArrayList<Book>();
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home(@RequestParam(name = "book", required = false)String name, Model model) {

		books = new ArrayList<Book>();
		Book book = new Book();
		model.addAttribute("book", book);
		return "index";
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String kasitteleKirjat(@ModelAttribute(name ="book") Book book, Model model) {
		books.add(book);
		model.addAttribute("books", book);
		
		book = new Book();
		model.addAttribute("book", book);
		return "index";
	}
}