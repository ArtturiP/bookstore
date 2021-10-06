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
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
		
		
	}
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Mystery"));
			crepository.save(new Category("Historical"));
			
			User user1 = new User("user", "$2a$10$/P2nLdOXVMR2I5K4YknElebDetVqdb96dGdjp5mHDzBnpRXuNrSg2", "user@gmail.com", "USER");
			User user2 = new User("admin", "$2a$10$E3y3Z5vuQGReMxn1FIcvdeUo4c1HZL3hHJ3GOz/BRd.swviaijk76", "admin@gmail.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
