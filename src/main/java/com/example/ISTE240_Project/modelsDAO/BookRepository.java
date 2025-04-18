package com.example.ISTE240_Project.modelsDAO;

import com.example.ISTE240_Project.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByGenreIgnoreCase(String genre);

    List<Book> findByReleaseDateAfter(LocalDate date);

    List<Book> findByReleaseDateBetween(LocalDate start, LocalDate end);
}