package com.example.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Bookstore.domain.Book;

@Controller
public class BookController {

    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("book", new Book());
        return "index";
    }

    @RequestMapping(value="/hello", method=RequestMethod.POST)
    public String greetingSubmit(@Validated Book book, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
        	return "index";
        }
        
    	model.addAttribute("book", book);
        return "result";
    }

}