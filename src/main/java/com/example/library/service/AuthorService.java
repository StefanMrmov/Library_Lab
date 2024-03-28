package com.example.library.service;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.model.Category;
import com.example.library.model.Country;

import java.util.List;
import java.util.Optional;
public interface AuthorService {
    List<Author> findAll();
    Optional<Author> findById(Long id);
    Optional<Author> save(String name, String surname, Long country);
    Optional<Author> edit(Long id,String name, String surname, Long country);
    void deleteById(Long id);
}
