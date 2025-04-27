package com.example.ISTE240_Project.modelsDAO;

import com.example.ISTE240_Project.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAll();

    Optional<Book> findById(int id);

    List<Book> findByPublicationDateBetween(LocalDate start, LocalDate end);

    List<Book> findByGenreIgnoreCase(String genre);

    List<Book> findByGenreIgnoreCaseIn(List<String> genres);
}