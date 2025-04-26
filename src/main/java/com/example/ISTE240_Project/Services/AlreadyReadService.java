package com.example.ISTE240_Project.Services;


import com.example.ISTE240_Project.Models.AlreadyRead;
import com.example.ISTE240_Project.Models.Book;
import com.example.ISTE240_Project.Models.CurrentlyReading;
import com.example.ISTE240_Project.modelsDAO.AlreadyReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlreadyReadService {

    @Autowired
    private AlreadyReadRepository alreadyReadRepository;

    @Autowired
    private CurrentlyReadingService currentlyReadingService;

    public void addBook(Book book, String email, LocalDate startDate, LocalDate endDate, String review, int rating) {
        AlreadyRead alreadyRead = new AlreadyRead();
        alreadyRead.setIsbn(book.getIsbn());
        alreadyRead.setTitle(book.getTitle());
        alreadyRead.setAuthor(book.getAuthor());
        alreadyRead.setDescription(book.getDescription());
        alreadyRead.setGenre(book.getGenre());
        alreadyRead.setPageCount(book.getPageCount());
        alreadyRead.setThumbnailUrl(book.getThumbnailUrl());
        alreadyRead.setPublicationDate(book.getPublicationDate());
        alreadyRead.setEmail(email);
        alreadyRead.setStartDate(startDate);
        alreadyRead.setEndDate(endDate);
        alreadyRead.setReview(review);
        alreadyRead.setRating(rating);
        alreadyReadRepository.save(alreadyRead);

    }

    public List<AlreadyRead> findBooksByEmail(String email) {
        return alreadyReadRepository.findAllByEmail(email);

    }

    public List<AlreadyRead> findReviewsByEmail(String email) {
        return alreadyReadRepository.findReviewsByEmail(email);
    }

    public List<AlreadyRead> getAllBooksSortedByRating(String email) {
        List<AlreadyRead> topbooks = alreadyReadRepository.findAllByEmailOrderByRatingDesc(email);
        List<AlreadyRead> favoritebooks = new ArrayList<>();
        for (int a =0; a<5; a++){
            if (a<topbooks.size()){
                favoritebooks.add(topbooks.get(a));
            }
        }
        return favoritebooks;
    }

    public double getUserAverageRating(String email) {
        double sum =0;
        int books =0;
        List<AlreadyRead> allBooks = alreadyReadRepository.findAllByEmail(email);
        for (AlreadyRead book : allBooks) {
            sum = sum + book.getRating();
            books++;
        }
        double result = sum/books;

        // Use math round to format the average rating nicely, it functions by rounding to the nearest
        // whole number. So it multiples by hundred, rounds, then divides by a hundred again to get the
        // correct nicely formatted decimal placement

        return Math.round(result * 100.0) / 100.0;

    }

    public int getUserPagesRead(String email) {
        List<AlreadyRead> allBooks = alreadyReadRepository.findAllByEmail(email);
        List<CurrentlyReading> currentlyReading = currentlyReadingService.findBooksByEmail(email);
        int sum = 0;
        for (AlreadyRead book : allBooks) {
            sum = sum + book.getPageCount();
        }
        for (CurrentlyReading book : currentlyReading) {
            sum = sum + book.getPagesRead();
        }

        return sum;
    }
}
