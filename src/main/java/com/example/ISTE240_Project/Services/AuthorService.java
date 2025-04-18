package com.example.nobel_prize.services;

import com.example.nobel_prize.models.Author;
import com.example.nobel_prize.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

        @Autowired
        private AuthorRepository authorRepository;

        @Autowired
        public AuthorService(AuthorRepository authorRepository) {
                this.authorRepository = authorRepository;
        }

        public List<Author> getAllAuthors() {
                return authorRepository.findAll();
        }

        public Author getAuthorByName(String name) {
                return authorRepository.findByNameIgnoreCase(name).orElse(null);
        }
}
