package com.example.library.service.impl;

import com.example.library.model.Author;
import com.example.library.model.Country;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.CountryRepository;
import com.example.library.service.AuthorService;

import java.util.List;
import java.util.Optional;

public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> save(String name, String surname, Long country) {
        Country country1=countryRepository.findById(country).orElseThrow(RuntimeException::new);
        Author author=new Author(name,surname,country1);
        return Optional.of(authorRepository.save(author));
    }

    @Override
    public Optional<Author> edit(Long id, String name, String surname, Long country) {
        Country country1=countryRepository.findById(country).orElseThrow(RuntimeException::new);
        Author author=findById(id).orElseThrow(RuntimeException::new);
        author.setName(name);
        author.setSurname(surname);
        author.setCountry(country1);
        return Optional.of(authorRepository.save(author));
    }

    @Override
    public void deleteById(Long id) {
    authorRepository.deleteById(id);
    }
}
