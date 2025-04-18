package com.example.ISTE240_Project.config;

import com.example.ISTE240_Project.Models.Book;
import com.example.ISTE240_Project.Models.FunFact;
import com.example.ISTE240_Project.Models.Quote;
import com.example.ISTE240_Project.modelsDAO.BookRepository;
import com.example.ISTE240_Project.modelsDAO.FunFactRepository;
import com.example.ISTE240_Project.modelsDAO.QuoteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private final BookRepository bookRepository;

    @Autowired
    private QuoteRepository quoteRepository;


    private final FunFactRepository funFactRepository;

    public DataLoader(BookRepository bookRepository, FunFactRepository funFactRepository) {
        this.bookRepository = bookRepository;
        this.funFactRepository = funFactRepository;
    }


    @Override
    @Transactional
    public void run(String... args) {
        if (quoteRepository.count() == 0) {
            quoteRepository.saveAll(List.of(
                    new Quote("A reader lives a thousand lives before he dies.", "George R.R. Martin"),
                    new Quote("So many books, so little time.", "Frank Zappa"),
                    new Quote("Until I feared I would lose it, I never loved to read. One does not love breathing.", "Harper Lee"),
                    new Quote("Books are a uniquely portable magic.", "Stephen King"),
                    new Quote("That's the thing about books. They let you travel without moving your feet.", "Jhumpa Lahiri"),
                    new Quote("Reading is essential for those who seek to rise above the ordinary.", "Jim Rohn"),
                    new Quote("A room without books is like a body without a soul.", "Marcus Tullius Cicero")

            ));
        }
        if (funFactRepository.count() == 0) {
            List<FunFact> funFacts = List.of(
                    new FunFact("The first book ever written using a typewriter was 'The Adventures of Tom Sawyer'."),
                    new FunFact("The most expensive book ever purchased was sold for $30.8 million."),
                    new FunFact("Bibliosmia is the enjoyment of the smell of old books."),
                    new FunFact("The longest sentence ever printed is 823 words long, in Victor Hugo's *Les Misérables*."),
                    new FunFact("J.K. Rowling was rejected by 12 publishers before *Harry Potter* was accepted.")
            );
            funFactRepository.saveAll(funFacts);
        }


    }
}