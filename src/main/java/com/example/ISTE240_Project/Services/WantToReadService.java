package com.example.ISTE240_Project.Services;


import com.example.ISTE240_Project.Models.AlreadyRead;
import com.example.ISTE240_Project.Models.Book;
import com.example.ISTE240_Project.Models.CurrentlyReading;
import com.example.ISTE240_Project.Models.WantToRead;
import com.example.ISTE240_Project.modelsDAO.CurrentlyReadingRepository;
import com.example.ISTE240_Project.modelsDAO.WantToReadRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WantToReadService {

    @Autowired
    private WantToReadRepository wantToReadRepository;




    // Implementing the add book method
    @Transactional
    public void addBook(Book book, String email) {

        WantToRead want_To_Read = new WantToRead();
        want_To_Read.setIsbn(book.getIsbn());
        want_To_Read.setTitle(book.getTitle());
        want_To_Read.setAuthor(book.getAuthor());
        want_To_Read.setDescription(book.getDescription());
        want_To_Read.setGenre(book.getGenre());
        want_To_Read.setPageCount(book.getPageCount());
        want_To_Read.setThumbnailUrl(book.getThumbnailUrl());
        want_To_Read.setPublicationDate(book.getPublicationDate());
        want_To_Read.setEmail(email);
        wantToReadRepository.save(want_To_Read);

    }

    public List<WantToRead> findBooksByEmail(String email) {
       return wantToReadRepository.findAllByEmail(email);

    }



}
