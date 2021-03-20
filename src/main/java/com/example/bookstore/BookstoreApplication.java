package com.example.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.bookstore.domain.Books;
import com.example.bookstore.domain.Category;
import com.example.bookstore.repository.BooksRepository;
import com.example.bookstore.repository.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private BooksRepository booksRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Informatics", "Informatics Books");
		Books l1 = new Books(null, "Clean code", "Robert Martin", "Loren ipsum", cat1);
		cat1.getBooks().addAll(Arrays.asList(l1));
		this.categoryRepository.saveAll(Arrays.asList(cat1));
		this.booksRepository.saveAll(Arrays.asList(l1));
		
		// TODO Auto-generated method stub
		
	}

}
