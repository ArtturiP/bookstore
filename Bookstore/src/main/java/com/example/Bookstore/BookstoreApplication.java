package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
		
		
	}
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Mystery"));
			crepository.save(new Category("Historical"));
			
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
