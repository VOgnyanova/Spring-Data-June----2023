package com.example.Spring.Data.Intro.Exercise.repositories;


import com.example.Spring.Data.Intro.Exercise.service.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Object> findById(long randomId);


}
