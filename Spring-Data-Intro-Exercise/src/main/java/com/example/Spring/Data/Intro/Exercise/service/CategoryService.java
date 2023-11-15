package com.example.Spring.Data.Intro.Exercise.service;

import jdk.jfr.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    boolean isDataSeeded();

    void seedCategories(List<Category> authors);

    Category getRandomCategory();

    Set<Category> getRandomCategories();
}
