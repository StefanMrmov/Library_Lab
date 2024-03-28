package com.example.library.service;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.model.Category;
import com.example.library.model.dto.BookDto;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Optional<Book> save(String name, Category category, Long author,int availableCopies);
    Optional<Book> save(BookDto bookDto);
    Optional<Book> edit(Long id,String name, Category category, Long author,int availableCopies);
    Optional<Book> edit(Long id,BookDto bookDto);
    void deleteById(Long id);

}
