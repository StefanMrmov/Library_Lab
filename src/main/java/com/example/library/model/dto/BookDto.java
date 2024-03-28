package com.example.library.model.dto;

import com.example.library.model.Author;
import com.example.library.model.Category;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class BookDto {
    private String name;

    private Category category;
    private Long author;
    private int availableCopies;

    public BookDto(String name, Category category, Long author, int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public BookDto() {

    }
}
