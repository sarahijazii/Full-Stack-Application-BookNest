package com.example.ISTE240_Project.Services;

import com.example.ISTE240_Project.Models.Book;
import com.example.ISTE240_Project.Models.CurrentlyReading;
import com.example.ISTE240_Project.modelsDAO.CurrentlyReadingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CurrentlyReadingService {

    @Autowired
    private CurrentlyReadingRepository currentlyReadingRepository;



    @Transactional 
    public void addBook(Book book, String email, int pagesRead, LocalDate startDate){
        CurrentlyReading currentlyReading = new CurrentlyReading();
        currentlyReading.setIsbn(book.getIsbn());
        currentlyReading.setTitle(book.getTitle());
        currentlyReading.setAuthor(book.getAuthor());
        currentlyReading.setDescription(book.getDescription());
        currentlyReading.setGenre(book.getGenre());
        currentlyReading.setPageCount(book.getPageCount());
        currentlyReading.setThumbnailUrl(book.getThumbnailUrl());
        currentlyReading.setPublicationDate(book.getPublicationDate());
        currentlyReading.setEmail(email);
        currentlyReading.setPagesRead(pagesRead);
        currentlyReading.setStartDate(startDate);
        int percent = (int)(((double) pagesRead / currentlyReading.getPageCount()) * 100);
        currentlyReading.setProgressBarPercentage(percent);

        currentlyReadingRepository.save(currentlyReading);

    }

    @Transactional
    public void updateBook(int id, int pagesRead){ /* Updates the amount of pages read and the progress bar */
        currentlyReadingRepository.findById(id).ifPresent(currentlyReading -> {
            currentlyReading.setPagesRead(pagesRead);
            int percent = (int)(((double) pagesRead / currentlyReading.getPageCount()) * 100);
            currentlyReading.setProgressBarPercentage(percent);
        });
    }

    public List<CurrentlyReading> findBooksByEmail(String email){
        return currentlyReadingRepository.findAllByEmail(email);
    }

    public Optional<CurrentlyReading> getBookById(int id) {
        return currentlyReadingRepository.findById(id);
    }


}
