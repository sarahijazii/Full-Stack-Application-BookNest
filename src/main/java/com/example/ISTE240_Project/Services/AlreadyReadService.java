package com.example.ISTE240_Project.Services;


import com.example.ISTE240_Project.Models.AlreadyRead;
import com.example.ISTE240_Project.Models.Book;
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

    public List<AlreadyRead> getAllBooksSortedByRating() {
        Iterable<AlreadyRead> topbooks = alreadyReadRepository.findAll(Sort.by(Sort.Direction.DESC, "rating"));
        List<AlreadyRead> topbookslist = new ArrayList<>();
        List<AlreadyRead> favoritebooks = new ArrayList<>();
        for (AlreadyRead book : topbooks){
            topbookslist.add(book);
        }
        for (int a =0; a<5; a++){
            favoritebooks.add(topbookslist.get(a));
        }

        return favoritebooks;
    }
}
