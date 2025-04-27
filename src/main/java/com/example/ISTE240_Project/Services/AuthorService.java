package com.example.ISTE240_Project.Services;

import com.example.ISTE240_Project.Models.Author;
import com.example.ISTE240_Project.modelsDAO.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

        @Autowired //injecting the AuthorRepository to perform database operations on Author data
        private AuthorRepository authorRepository;

        @Autowired
        public AuthorService(AuthorRepository authorRepository) {
                this.authorRepository = authorRepository;
        }

        public List<Author> getAllAuthors() {
                return authorRepository.findAll(); //retrieves a list of all authors from the database
        }

        //retrieves an author by their name, ignoring case sensitivity
        public Author getAuthorByName(String name) {
                return authorRepository.findByNameIgnoreCase(name).orElse(null);
        }
}
