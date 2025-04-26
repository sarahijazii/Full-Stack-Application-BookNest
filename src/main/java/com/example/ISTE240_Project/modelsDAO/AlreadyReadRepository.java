package com.example.ISTE240_Project.modelsDAO;


import com.example.ISTE240_Project.Models.AlreadyRead;
import com.example.ISTE240_Project.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlreadyReadRepository extends JpaRepository<AlreadyRead,Integer> {

    public List<AlreadyRead> findAllByEmail(String email);
    public List<AlreadyRead> findReviewsByEmail(String email);
    List<AlreadyRead> findAllByEmailOrderByRatingDesc(String email);
    List<AlreadyRead> findByEmailAndGenreIgnoreCase(String email,String genre);



}
