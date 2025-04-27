package com.example.ISTE240_Project.Services;


import com.example.ISTE240_Project.Models.AlreadyRead;
import com.example.ISTE240_Project.Models.Book;
import com.example.ISTE240_Project.Models.CurrentlyReading;
import com.example.ISTE240_Project.modelsDAO.AlreadyReadRepository;
import jakarta.transaction.Transactional;
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
        List<AlreadyRead> topbooks = alreadyReadRepository.findAllByEmailOrderByRatingDesc(email); /* Ranks a user's books from highest to lowest rating  */
        List<AlreadyRead> favoritebooks = new ArrayList<>();
        for (int a =0; a<5; a++){
            if (a<topbooks.size()){
                favoritebooks.add(topbooks.get(a)); /* Adds the user's top five books in a new list */
            }
        }
        return favoritebooks; /* Returns the new list */
    }

    public double getUserAverageRating(String email) {
        double sum =0;
        int books =0;
        List<AlreadyRead> allBooks = alreadyReadRepository.findAllByEmail(email);
        for (AlreadyRead book : allBooks) {
            sum = sum + book.getRating();
            books++;
        }
        double result = sum/books; /* Calculates the average rating */

        /* Use math round to format the average rating nicely, it functions by rounding to the nearest
        whole number. So it multiples by hundred, rounds, then divides by a hundred again to get the
        correct nicely formatted decimal placement */

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
        } /* Sums up the total page counts of the books already read as well as the pages read from the currently reading books */

        return sum;
    }

    public List<AlreadyRead> getByGenre(String email,String genre) {
        return alreadyReadRepository.findByEmailAndGenreIgnoreCase(email,genre);
    }

    /* Gets the count of how many times a genre is read and performs a comparison to determine which is the greatest count.
    The genre read the most is returned as the user's favorite genre */
    public String getUserFavouriteGenre(String email) {
        int romancecount = getByGenre(email,"romance").size();
        int scificount = getByGenre(email,"sci-fi").size();
        int nonfictioncount = getByGenre(email,"nonfiction").size();
        int biographycount = getByGenre(email,"biography").size();
        int fantasycount = getByGenre(email,"fantasy").size();
        int horrorcount = getByGenre(email,"horror").size();
        int mysterycount = getByGenre(email,"mystery").size();
        int thrillercount = getByGenre(email,"thriller").size();
        if (romancecount > scificount && romancecount > nonfictioncount && romancecount > biographycount && romancecount > fantasycount && romancecount > horrorcount && romancecount > mysterycount && romancecount > thrillercount) {
            return "Romance";
        } else if (scificount > romancecount && scificount > nonfictioncount && scificount > biographycount && scificount > fantasycount && scificount > horrorcount && scificount > mysterycount && scificount > thrillercount) {
            return "Sci-Fi";
        } else if (nonfictioncount > romancecount && nonfictioncount > scificount && nonfictioncount > biographycount && nonfictioncount > fantasycount && nonfictioncount > horrorcount && nonfictioncount > mysterycount && nonfictioncount > thrillercount) {
            return "Nonfiction";
        } else if (biographycount > romancecount && biographycount > scificount && biographycount > nonfictioncount && biographycount > fantasycount && biographycount > horrorcount && biographycount > mysterycount && biographycount > thrillercount) {
            return "Biography";
        } else if (fantasycount > romancecount && fantasycount > scificount && fantasycount > nonfictioncount && fantasycount > biographycount && fantasycount > horrorcount && fantasycount > mysterycount && fantasycount > thrillercount) {
            return "Fantasy";
        } else if (horrorcount > romancecount && horrorcount > scificount && horrorcount > nonfictioncount && horrorcount > biographycount && horrorcount > fantasycount && horrorcount > mysterycount && horrorcount > thrillercount) {
            return "Horror";
        } else if (mysterycount > romancecount && mysterycount > scificount && mysterycount > nonfictioncount && mysterycount > biographycount && mysterycount > fantasycount && mysterycount > horrorcount && mysterycount > thrillercount) {
            return "Mystery";
        } else if (thrillercount > romancecount && thrillercount > scificount && thrillercount > nonfictioncount && thrillercount > biographycount && thrillercount > fantasycount && thrillercount > horrorcount && thrillercount > mysterycount) {
            return "Thriller";
        } else {
            return "In Discovery!"; // if all counts are 0 or equal
        }

    }

}
