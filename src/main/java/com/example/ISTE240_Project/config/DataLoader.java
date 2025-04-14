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
        if (bookRepository.count() == 0) {
            List<Book> books = List.of(
                    new Book("The Silent Patient", "Alex Michaelides", "Thriller", LocalDate.of(2023, 6, 15), "images/the-silent-patient.png"),
                    new Book("Project Hail Mary", "Andy Weir", "Sci-Fi", LocalDate.of(2021, 5, 4), "/images/project.png"),
                    new Book("Circe", "Madeline Miller", "Fantasy", LocalDate.of(2018, 4, 10), "images/circe.png"),
                    new Book("Educated", "Tara Westover", "Non-Fiction", LocalDate.of(2018, 2, 20), "/images/educated.png"),
                    new Book("The Night Circus", "Erin Morgenstern", "Fantasy", LocalDate.of(2011, 9, 13), "/images/night.png"),
                    new Book("Verity", "Colleen Hoover", "Thriller", LocalDate.of(2018, 12, 7), "/images/verity.png"),
                    new Book("Dune", "Frank Herbert", "Sci-Fi", LocalDate.of(1965, 8, 1), "/images/dune.png"),
                    new Book("Pachinko", "Min Jin Lee", "Historical", LocalDate.of(2017, 2, 7), "/images/pach.png"),
                    new Book("1984", "George Orwell", "Sci-Fi", LocalDate.of(1949, 6, 8), "/images/1984.png"),
                    new Book("Becoming", "Michelle Obama", "Non-Fiction", LocalDate.of(2018, 11, 13), "/images/becoming.png"),
                    new Book("The Book Thief", "Markus Zusak", "Historical", LocalDate.of(2005, 3, 14), "/images/the-book-thief.png"),
                    new Book("The Midnight Library", "Matt Haig", "Fantasy", LocalDate.of(2020, 9, 29), "/images/midnight.png"),
                    new Book("A Man Called Ove", "Fredrik Backman", "Fiction", LocalDate.of(2012, 8, 27), "/images/man.png"),
                    new Book("Atomic Habits", "James Clear", "Non-Fiction", LocalDate.of(2018, 10, 16), "/images/atomic.png"),
                    new Book("Where the Crawdads Sing", "Delia Owens", "Romance", LocalDate.of(2018, 8, 14), "/images/silent.png"),
                    new Book("The Alchemist", "Paulo Coelho", "Fantasy", LocalDate.of(1988, 4, 15), "/images/alchemist.png"),
                    new Book("The Paris Library", "Janet Skeslien Charles", "Historical", LocalDate.of(2021, 2, 9), "/images/paris.png"),
                    new Book("The Seven Husbands of Evelyn Hugo", "Taylor Jenkins Reid", "Romance", LocalDate.of(2017, 6, 13), "/images/seven.png"),
                    new Book("The Four Winds", "Kristin Hannah", "Historical", LocalDate.of(2021, 2, 2), "/images/four.png"),
                    new Book("The Giver of Stars", "Jojo Moyes", "Historical", LocalDate.of(2019, 10, 3), "/images/giver.png"),
                    new Book("Reminders of Him", "Colleen Hoover", "Romance", LocalDate.of(2022, 1, 18), "/images/reminder.png"),
                    new Book("November 9", "Colleen Hoover", "Romance", LocalDate.of(2015, 11, 10), "/images/nov.png"),
                    new Book("The House in the Cerulean Sea", "TJ Klune", "Fantasy", LocalDate.of(2020, 3, 17), "/images/house.png"),
                    new Book("Book Lovers", "Emily Henry", "Romance", LocalDate.of(2022, 5, 3), "/images/book-lovers.png"),
                    new Book("People We Meet on Vacation", "Emily Henry", "Romance", LocalDate.of(2021, 5, 11), "/images/vacation.png"),
                    new Book("The Invisible Life of Addie LaRue", "V.E. Schwab", "Fantasy", LocalDate.of(2020, 10, 6), "/images/invisible.png"),
                    new Book("Mexican Gothic", "Silvia Moreno-Garcia", "Horror", LocalDate.of(2020, 6, 30), "/images/mexican.png"),
                    new Book("The Final Girl Support Group", "Grady Hendrix", "Horror", LocalDate.of(2021, 7, 13), "/images/final.png"),
                    new Book("The Last Thing He Told Me", "Laura Dave", "Thriller", LocalDate.of(2021, 5, 4), "/images/last.png"),
                    new Book("Sharp Objects", "Gillian Flynn", "Thriller", LocalDate.of(2006, 9, 26), "/images/sharp.png"),
                    new Book("Gone Girl", "Gillian Flynn", "Thriller", LocalDate.of(2012, 6, 5), "/images/gone.png"),
                    new Book("Big Little Lies", "Liane Moriarty", "Fiction", LocalDate.of(2014, 7, 29), "/images/lies.png"),
                    new Book("The Guest List", "Lucy Foley", "Thriller", LocalDate.of(2020, 2, 20), "/images/guest.png"),
                    new Book("The Hunting Party", "Lucy Foley", "Thriller", LocalDate.of(2018, 12, 6), "/images/hunting.png"),
                    new Book("The Chain", "Adrian McKinty", "Thriller", LocalDate.of(2019, 7, 9), "/images/chain.png"),
                    new Book("The Push", "Ashley Audrain", "Thriller", LocalDate.of(2021, 1, 5), "/images/push.png"),
                    new Book("Before She Knew Him", "Peter Swanson", "Thriller", LocalDate.of(2019, 3, 5), "/images/before.png"),
                    new Book("The Paris Library", "Janet Skeslien Charles", "Historical", LocalDate.of(2021, 2, 9), "/images/paris.png"),
                    new Book("The Alice Network", "Kate Quinn", "Historical", LocalDate.of(2017, 6, 6), "/images/network.png"),
                    new Book("The Tattooist of Auschwitz", "Heather Morris", "Historical", LocalDate.of(2018, 1, 27), "/images/tattooist.png"),
                    new Book("Cilka's Journey", "Heather Morris", "Historical", LocalDate.of(2019, 10, 1), "/images/cil.png"),
                    new Book("The Atlas Complex", "Olivie Blake", "Fantasy", LocalDate.of(2025, 1, 9), "/images/atlas_complex.png"),
                    new Book("Wandering Stars", "Tommy Orange", "Fiction", LocalDate.of(2025, 2, 27), "/images/wandering_stars.png"),
                    new Book("The Fury", "Alex Michaelides", "Thriller", LocalDate.of(2025, 1, 16), "/images/the_fury.png"),
                    new Book("You Like It Darker", "Stephen King", "Horror", LocalDate.of(2025, 5, 21), "/images/you_like_it_darker.png"),
                    new Book("Funny Story", "Emily Henry", "Romance", LocalDate.of(2025, 6, 18), "/images/funny_story.png"),
                    new Book("The Familiar", "Leigh Bardugo", "Fantasy", LocalDate.of(2025, 9, 17), "/images/the_familiar.png"),
                    new Book("The Glassmaker", "Tracy Chevalier", "Historical", LocalDate.of(2025, 7, 30), "/images/the_glassmaker.png")


                    );
            bookRepository.saveAll(books);
        }
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