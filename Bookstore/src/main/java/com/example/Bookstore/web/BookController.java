package com.example.Bookstore.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;

	

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
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
	
	@RequestMapping(value="/booklist")
	public String bookList(Model model) {
	model.addAttribute("books", repository.findAll());
	return "booklist";
	}
	
	@RequestMapping(value = "/add")
	public String addBook(Model model){
	 model.addAttribute("book", new Book());
	 model.addAttribute("categories", crepository.findAll());
	 return "addbook";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book){
	 repository.save(book);
	 return "redirect:booklist";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
	 repository.deleteById(bookId);
	 return "redirect:../booklist";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String addBook(@PathVariable("id") Long bookId, Model model){
	 model.addAttribute("book", repository.findById(bookId));
	 model.addAttribute("categories", crepository.findAll());
	 return "editbook";
	}

}