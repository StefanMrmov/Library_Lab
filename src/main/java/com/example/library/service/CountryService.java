package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.Category;
import com.example.library.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> findById(Long id);
    Optional<Country> save(String name, String continent);
    Optional<Country> edit(Long id,String name, String continent);
    void deleteById(Long id);
}
