package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.example.Entity.Book;
import com.example.Repository.BookRepository;

@SpringBootApplication
public class SpringpagingandsortingApplication implements CommandLineRunner {
	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringpagingandsortingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		bookRepository.save(new Book(1,"title1","author1"));
		bookRepository.save(new Book(2,"title2","author2"));
		bookRepository.save(new Book(3,"title3","author3"));
		bookRepository.save(new Book(4,"title4","author4"));
		
		int page;
		int size;
		PageRequest pageRequest=PageRequest.of(0, 2, Sort.by("title").descending());
		Page<Book>bookPage=bookRepository.findAll(pageRequest);
		System.out.println("paged data:");
		bookPage.getContent().forEach(System.out::println);
		PageRequest pageRequest1=PageRequest.of(1, 2,Sort.by("id") );
		Page<Book>bookPage1=bookRepository.findAll(pageRequest1);
		System.out.println("paged data:");
		bookPage1.getContent().forEach(System.out::println);
		
		Sort sort=Sort.by(Sort.Direction.DESC,"id");
		Iterable<Book>sortedBooks=bookRepository.findAll(sort);
		System.out.println("sorted data:");
		sortedBooks.forEach(System.out::println);
		
		
	}

}
