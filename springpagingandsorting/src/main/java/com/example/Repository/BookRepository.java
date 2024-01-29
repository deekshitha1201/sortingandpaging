package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
