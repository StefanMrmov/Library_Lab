package com.example.library.service.impl;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.model.Category;
import com.example.library.model.dto.BookDto;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(String name, Category category, Long author, int availableCopies) {
        Author authorr=authorRepository.findById(author).orElseThrow(RuntimeException::new);
        Book book=new Book(name,category,authorr,availableCopies);
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author authorr=authorRepository.findById(bookDto.getAuthor()).orElseThrow(RuntimeException::new);
       // bookRepository.deleteByName(bookDto.getName());
        Book book=new Book(bookDto.getName(),bookDto.getCategory(),authorr,bookDto.getAvailableCopies());
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> edit(Long id, String name, Category category, Long author, int availableCopies) {
        Author authorr=authorRepository.findById(author).orElseThrow(RuntimeException::new);
        Book book=findById(id).orElseThrow(RuntimeException::new);
        book.setName(name);
        book.setCategory(category);
        book.setAuthor(authorr);
        book.setAvailableCopies(availableCopies);
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> edit(Long id,BookDto bookDto) {
        Author authorr=authorRepository.findById(bookDto.getAuthor()).orElseThrow(RuntimeException::new);
        Book book=findById(id).orElseThrow(RuntimeException::new);
        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(authorr);
        book.setAvailableCopies(bookDto.getAvailableCopies());
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public void deleteById(Long id) {
bookRepository.deleteById(id);
    }
}
