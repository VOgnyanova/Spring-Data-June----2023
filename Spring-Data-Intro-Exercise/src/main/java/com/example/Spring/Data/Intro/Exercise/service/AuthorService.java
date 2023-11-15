package com.example.Spring.Data.Intro.Exercise.service;

import com.example.Spring.Data.Intro.Exercise.domain.entities.Author;

import java.time.LocalDate;
import java.util.List;

public interface AuthorService {
    boolean isDataSeeded();
    void seedAuthors(List<Author>authors);
    Author  getRandomAuthor();
    List<Author> getAllAuthorsWithBooksBeforeYear(LocalDate date);

    List<Author> getAllAuthorsOrederByBooksDesc();
}
