package com.example.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.repository.CategoryRepository;
import com.example.bookstore.domain.Books;
import com.example.bookstore.domain.Category;
import com.example.bookstore.repository.BooksRepository;

@Service
public class DBService {
	@Autowired
	private CategoryRepository CategoryRepository;
	@Autowired
	private BooksRepository BooksRepository;
	
	public void instanciaBaseDeDados() {
		
		Category cat1 = new Category(null, "Informatics", "Informatics book");
		Category cat2 = new Category(null, "Science Fiction", "Science Fiction");
		Category cat3 = new Category(null, "Biographies", "Biography Books");

		Books l1 = new Books(null, "Clean Code", "Robert Martin", "Lorem ipsum", cat1);
		Books l2 = new Books(null, "Engenharia de Software", "Louis V. Gerstner", "Lorem ipsum", cat1);
		Books l3 = new Books(null, "The Time Machine", "H.G. Wells", "Lorem ipsum", cat2);
		Books l4 = new Books(null, "The War of the Worlds", "H.G. Wells", "Lorem ipsum", cat2);
		Books l5 = new Books(null, "I, Robot", "Isaac Asimov", "Lorem ipsum", cat2);

		cat1.getBooks().addAll(Arrays.asList(l1, l2));
		cat2.getBooks().addAll(Arrays.asList(l3, l4, l5));

		CategoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		BooksRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}

}
