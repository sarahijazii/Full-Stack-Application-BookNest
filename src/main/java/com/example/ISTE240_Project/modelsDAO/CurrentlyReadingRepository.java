package com.example.ISTE240_Project.modelsDAO;

import com.example.ISTE240_Project.Models.CurrentlyReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CurrentlyReadingRepository extends JpaRepository<CurrentlyReading,Integer> {

    public List<CurrentlyReading> findAllByEmail(String email);
    public Optional<CurrentlyReading> findById(int id);


}
